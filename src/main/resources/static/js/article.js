$.ajax({
  type: 'post',
  url: '/api/article',
  dataType: 'json',
  success: function (data) {
    // let source = $("#list-template").html();

    // let template = Handlebars.compile(source);
    // let html = template(data.data);

    // $('body').append(html);
    let source = $('#list-template').html();
    let template = Handlebars.compile(source);
    let html = template(data.data);

    $("#listData").html(html);
  },
  error: function () {
    alert('실패');
  },
});