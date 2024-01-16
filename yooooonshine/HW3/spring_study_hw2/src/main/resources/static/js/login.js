
function checkId(id) {
    if(id == ""){
        alert('아이디를 입력해주세요.');
        return false;
    }
    return true;
}

function checkPassword(password) {
    if(password == ""){
        alert('패스워드를 입력해주세요.');
        return false;
    }
    return true;
}

function login() {
    let id = $("#id").val();
    let password = $("#password").val();

    if (!checkId(id)) {
        return;
    }

    if (!checkPassword(password)) {
        return;
    }

    $.ajax({
        type: 'post',
        url: '/login',
        data: {'id': id,
            'password': password},
        dataType: 'JSON',
        success: function (data) {
            if (!data.result) { //없으면 result가 true이다.
                alert('아이디 혹은 비밀번호가 일치하지 않습니다.'); //상수처리하기
            } else {
                localStorage.setItem('userId', id);
                window.location.replace('/main');
            }
        }

    });
}

