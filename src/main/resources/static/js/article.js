$.ajax({
  type: 'get',
  url: '/api/article',
  dataType: 'json',
  success: function (data) {
    $("#list-template").html(data);
  },
  error: function () {
    alert('실패');
  },
});