function sendText() {
    let text = $("#textInput").val();
    $.ajax({
        type: 'post',
        url: '/main/text',
        data: {
            'text': text,
        },
        dataType: 'JSON',
        success: function (data) {
            $("#textBox").empty();
            $("#textBox").text(data.text);
        }
    })
}

function sendText1() {
    let text = $("#textInput1   ").val();
    $.ajax({
        type: 'get',
        url: '/main/text/' + text,
        // data: {
        //     'text': text,
        // },
        dataType: 'JSON',
        success: function (data) {
            $("#textBox1").empty();
            $("#textBox1").text(data.text);
        }
    })
}