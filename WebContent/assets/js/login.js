/**
 * 
 */
// js로 req객체에 직접 접근하는 것은 불가능하다.
// 그러나 브라우저 주소창에 있는 쿼리스트링을 가져와 쓸 수 있다.
// window -> 브라우저
// location -> 주소창
// window가 브라우저의 여러 속성/값을 가지고 있다. location - 브라우저가 주소창을 가지고 있다.
console.log(window.location.search) 

// 쿼리스트링을 가져와도 String임
let queryString = location.search;

// 문자열로 된 쿼리스트링을 해석해주는 객체가 있다 = URLSearchParams
let urlParams = new URLSearchParams(queryString);

let login = urlParams.get('login');

if(login=='fail'){
	alert('일치하는 회원 정보가 없습니다.');
}

