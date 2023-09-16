


const getUserInfor = (id,username,password,email,phone,role)=>{
    const idInput = document.getElementById('id');
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');
    const emailInput = document.getElementById('email');
    const phoneInput = document.getElementById('phone');

    const roleInput = document.getElementById('role');


    idInput.value = id;
    usernameInput.value = username;
    passwordInput.value = password;
    emailInput.value = email;
    phoneInput.value = phone;
    roleInput.value = role;
}

