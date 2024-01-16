function requestUsers() {
    $.ajax({
        type: 'post',
        url: '/users',
        Type: 'JSON',
        success: function (data) {
            $("#textBox").empty();
            for (let userName of data.userNames) {
                $("#textBox").text(userName);
            }

        }
    })
}


window.onload = function () {
    requestUsers();
};