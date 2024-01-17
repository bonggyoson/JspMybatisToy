// 데이터 조회 Ajax
function getAjax(type, url, param, dataType, paging) {
  $.ajax({
    type: type,
    url: url,
    param: param,
    dataType: dataType,
    success: function (data) {
      // 총 개수
      $("#totalNum").html(data.data.total);

      // 데이터
      let list = $("#list-template").html();
      let listTemplate = Handlebars.compile(list);
      let listView = listTemplate(data.data);
      console.log(data);

      $("#listData").html(listView);
      if (paging) {
        // 페이지네이션
        let pagination = $("#page-template").html();
        let pageTemplate = Handlebars.compile(pagination);
        let pageView = pageTemplate(data.data);

        $("#pageData").html(pageView);
      }
    },
    error: function () {
      alert("요청이 실패 했습니다.");
    }
  });
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
      if (url.indexOf("member") !== -1) {
        window.location.href = "/login";
      } else {
        window.location.href = "/article";
        // // 데이터
        // let list = $("#template").html();
        // let listTemplate = Handlebars.compile(list);
        // let listView = listTemplate(data.data);
        //
        // $("#data").html(listView);
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