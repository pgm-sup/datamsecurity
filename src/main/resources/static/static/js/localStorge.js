// if(localStorage['sessionId']){
//     axios.defaults.headers.common['Authorization'] = localStorage.sessionId;
// }else{
//     window.location.href='../static.html';
// }
if(localStorage['sessionId']){
    $.ajaxSetup({
        headers:{
            'Content-Type':'application/x-www-form-urlencoded',
            'Authorization': localStorage.sessionId,
        }
    })
}else{
    window.location.href='../login.html';
}
