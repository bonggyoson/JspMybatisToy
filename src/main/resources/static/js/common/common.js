function getListAjax(type, url, param, dataType) {
  $.ajax({
    type: type,
    url: url,
    param: param,
    dataType: dataType,
    success: function (data) {
      if (data.status === "OK") {
        // 총 개수
        $("#totalNum").html(data.data.total);

        // 데이터
        let list = $("#list-template").html();
        let listTemplate = Handlebars.compile(list);
        let listView = listTemplate(data.data);

        $("#listData").html(listView);

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

function getAjax(type, url, data, dataType) {
  $.ajax({
    type: type,
    url: url,
    data: JSON.stringify(data),
    dataType: dataType,
    contentType: "application/json; charset=utf-8",
    success: function (data) {
      if (data.data === 1) {
        alert("요청이 성공하였습니다.");
        if (url.indexOf("member") !== -1) {
          window.location.href = "/login";
        } else {
          window.location.href = "/article";
          // 데이터
          let list = $("#template").html();
          let listTemplate = Handlebars.compile(list);
          let listView = listTemplate(data.data);

          $("#data").html(listView);
        }
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