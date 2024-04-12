// 데이터 조회 Ajax
function getAjax(type, url, param, dataType, paging) {
  if (paging) {
    // Return -> List
    $.ajax({
      type: type,
      url: url,
      param: param,
      dataType: dataType,
      success: function (data) {
        // 총 개수
        $("#totalNum").html(data.data.total);

        // 페이지
        $("#pageNum").html(data.data.pageNum);

        // 데이터
        let list = $("#list-template").html();
        let listTemplate = Handlebars.compile(list);
        let listView = listTemplate(data.data);
        console.log(data);

        $("#listData").html(listView);

        // 페이지네이션
        let pagination = $("#page-template").html();
        let pageTemplate = Handlebars.compile(pagination);
        let pageView = pageTemplate(data.data);

        $("#pageData").html(pageView);
        $("#" + data.data.pageNum + "page").addClass('active');
      },
      error: function () {
        alert("요청이 실패 했습니다.");
      }
    });
  } else {
    // Return -> Not List
    $.ajax({
      type: type,
      url: url,
      param: param,
      dataType: dataType,
      success: function (data) {
        console.log(data);
        // 데이터
        let list = $("#data-template").html();
        let listTemplate = Handlebars.compile(list);
        let listView = listTemplate(data.data);

        $("#listData").html(listView);
      },
      error: function () {
        alert("요청이 실패 했습니다.");
      }
    });
  }
}

// 데이터 입력, 수정, 삭제 Ajax
function submitAjax(type, url, data, dataType, contentType) {
  $.ajax({
    type: type,
    url: url,
    data: dataType === 'json' ? JSON.stringify(data) : data,
    dataType: dataType,
    contentType: contentType,
    success: function (data) {
      console.log(data);
      redirect_callback(url, data);
    },
    error: function () {
      swalToast("요청이 실패 했습니다.", "error");
    }
  });
}

function getFormData($form) {
  let unindexed_array = $form.serializeArray();
  let indexed_array = {};

  $.map(unindexed_array, function (n, i) {
    indexed_array[n['name']] = n['value'];
  });

  console.log(indexed_array);
  return indexed_array;
}

// Sweet Toast
function swalToast(message, icon) {
  const toast = Swal.mixin({
    toast: true,
    position: 'bottom-center',
    showConfirmButton: false,
    timer: 2000,
    timerProgressBar: true,
    textDecorationColor: 'black'
  })

  if (icon === "success") {
    toast.fire({
      icon: 'success',
      title: message,
    });
  } else if (icon === "error") {
    toast.fire({
      icon: 'error',
      title: message,
    });
  } else if (icon === "warning") {
    toast.fire({
      icon: 'warning',
      title: message,
    })
  }

}

// redirectUrl
function redirect_callback(url, data) {
  if (url.indexOf("join") !== -1) {
    swalToast("회원가입이 완료되었습니다.", "success");
    setTimeout(() => {
      window.location.href = "/login";
    }, 2000);
  } else if (url.indexOf("insert") !== -1) {
    let redirectUrl = url.replace(/\/api/i, '').replace(
        new RegExp("insert", "gi"), '');

    window.location.href = redirectUrl + data.data;

    // 데이터
    let list = $("#template").html();
    let listTemplate = Handlebars.compile(list);
    let listView = listTemplate(data.data);

    $("#data").html(listView);
  } else if (url.indexOf("update") !== -1) {
    if (url.indexOf("member") !== -1) {
      swalToast("회원정보가 수정되었습니다.", "success");
      setTimeout(() => {
        window.location.reload();
      }, 2000);
    }
  } else if (url.indexOf("delete") !== -1) {
    if (url.indexOf("member") !== -1) {
      swalToast("회원탈퇴가 완료되었습니다.", "success");
      setTimeout(() => {
        window.location.href = "/login";
      }, 2000);
    }
    window.history.back();
  } else {
    swalToast("임시비밀번호가 발송되었습니다. \n로그인 후 비밀번호를 재설정 해주세요.", "success");
    setTimeout(() => {
      window.history.back();
    }, 2000);
  }
}

// CapsLock Check
function checkCapsLock(e) {
  if (e.getModifierState("CapsLock")) {
    $("#passwordValid").html("Caps Lock이 켜져 있습니다.");
    $("#passwordValid").css({'color': 'red'});
  } else {
    $("#passwordValid").html("")
  }
}

// Null Check
function checkNull(value) {
  if (value === "" || value === null || value === undefined || (value !== null
      && typeof value === "object" && !Object.keys(value).length)) {
    return true;
  } else {
    return false;
  }
}