/**
 * 
 *//**
* 
*/

let $checkMsg = $("#check-id-msg");
let $checkPwMsg = $('#check-pw-msg');

let $idInput = $("#id");
let $pwInput = $("#password");


$idInput.on('blur', function() {
	if ($(this).val() == '') {
		$checkMsg.text('아이디를 입력하세요');
	}else{
		let id = $idInput.val();
		$.ajax({
		url: '/member/checkIdOk.me',
		type: 'get',
		data: { memberId: id },
		success: function(result) {
			$checkMsg.text(result);
		},
		error: function(a, b, c) {
			console.log(c);
		}
	});
	}
});

//중복 검사를 위한 ajax
/*$idInput.on('change', function() {

	let id = $idInput.val();
	$.ajax({
		url: '/member/checkIdOk.me',
		type: 'get',
		data: { memberId: id },
		success: function(result) {
			$checkMsg.text(result);
		},
		error: function(a, b, c) {
			console.log(c);
		}
	});
});*/

//대소문자 상관없이 영어포함, 숫자포함, 특수문자포함, 8글자 이상인 정규표현식
const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,}$/;

$pwInput.on('blur', function(){
	if(regex.test( $(this).val() ) ){
		$checkPwMsg.text("사용 가능한 비밀번호 입니다.");
	}else{
		$checkPwMsg.html("사용 불가능한 비밀번호 입니다. <br>영어, 숫자, 특수문자를 포함하여 8글자 이상 작성하세요!")
	}
});


//약관동의 체크박스를 체크하지 않으면 submit하지 못하게 막는다
$('form').on('submit', function(e){
	e.preventDefault(); //기본이벤트를 막아주는 명령어
	
	console.log($('#agree').prop('checked'));
	
	if($('#agree').prop('checked')){
		this.submit();	//서브밋 이벤트를 발생시키는 메소드(폼 요소에 사용해야 함)
	}else{
		alert('약관에 동의 해 주세요!');
	}
	
});


