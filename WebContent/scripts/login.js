const loginForm = document.querySelector("form.login");
const senhaForm = document.querySelector("form.senha");
const loginBtn = document.querySelector("label.login");
const senhaBtn = document.querySelector("label.senha");
const senhaLink = document.querySelector(".senha-link a");

senhaBtn.onclick = (() => {
	loginForm.style.marginLeft = "-50%";
});

loginBtn.onclick = (() => {
	loginForm.style.marginLeft = "0%";
});	

senhaLink.onclick = (() => {
	senhaBtn.click();
});	
