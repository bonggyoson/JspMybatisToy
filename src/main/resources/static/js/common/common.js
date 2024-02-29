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
    data: JSON.stringify(data),
    dataType: dataType,
    contentType: contentType,
    success: function (data) {
      console.log(data);
      if (url.indexOf("join") !== -1) {
        window.location.href = "/login";
      } else if (url.indexOf("insert") !== -1) {
        window.location.href = "/article/" + data.data;
        // 데이터
        let list = $("#template").html();
        let listTemplate = Handlebars.compile(list);
        let listView = listTemplate(data.data);

        $("#data").html(listView);
      }
    },
    error: function () {
      alert("요청이 실패 했습니다.");
    }
  });
}

function getFormData($form) {
  let unindexed_array = $form.serializeArray();
  let indexed_array = {};

  $.map(unindexed_array, function (n, i) {
    indexed_array[n['name']] = n['value'];
  });

  return indexed_array;
}

// Sweet Toast
function swalToast() {
  const Toast = Swal.mixin({
    toast: true,
    position: 'top-center',
    showConfirmButton: false,
    timer: 1500,
    timerProgressBar: true,
    textDecorationColor: 'black',
    didOpen: (toast) => {
      toast.addEventListener('mouseenter', Swal.stopTimer)
      toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
  })

  Toast.fire({
    icon: 'success',
    title: '회원정보가 수정 되었습니다.'
  })
}
