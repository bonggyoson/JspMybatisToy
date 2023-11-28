function ajax(type, url, param, callback) {
  $.ajax({
    type: type,
    url: url,
    data: param,
    success: function (data, status, xr) {
      // $("#test").html(data);
    },
    error: function (xhr, status, error) {
      return callback(data)
    }
  });
}