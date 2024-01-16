//회원가입 확인 클래스
class SignUpCheck {
    constructor() {
        this.idCheck = false;
        this.passwordCheck = false;
    }

    setIdCheck(value) {
        this.idCheck = value;
    }

    checkPassword() {
        let pw1 = $("#password1").val();
        let pw2 = $("#password2").val();
        if (!this.isBlank(pw1) || !this.isBlank(pw2)) {
            if (pw1 === pw2) {
                this.passwordCheck = true; // 비밀번호같으면 pwc true
            } else {
                this.passwordCheck = false;
            }
        }
    }

    isBlank(value) {
        if (value == "") {
            return true;
        }
        return false;
    }

    isAllTrue() {
        if (this.idCheck == false) {
            alert('아이디를 확인 해 주세요');
            return false;
        }
        if (this.passwordCheck == false) {
            alert('비밀번호를 확인 해 주세요');
            return false;
        }
        return true;
    }
}

const signUpCheck = new SignUpCheck();

//아이디 중복체크
function checkId() {
    let id = $("#id").val();
    $.ajax({
        type: 'post',
        url: '/id-duplication-check',
        data: {'id': id},
        dataType: 'JSON',
        success: function (data) {
            if (data.result) {
                signUpCheck.setIdCheck(true);
                alert('사용할 수 있는 아이디 입니다.');
            } else {
                signUpCheck.setIdCheck(false);
                alert('이미 사용중인 아이디 입니다.');

            }
        }
    });
}


function signup() {

    // var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    // if (!regExp.test(email)) {
    //     alert('이메일 형식이 아닙니다');
    //     doc.getElementById('email').value = '';
    //     doc.getElementById('email').focus();
    //     return;
    // }
    signUpCheck.checkPassword();

    if (signUpCheck.isAllTrue()) {
        console.log("여기자나");
        $('form').submit();
    }
}