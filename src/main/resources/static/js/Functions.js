// show name of the sessionStorage item "user"
$(document).ready(function () {
    var userJSON = sessionStorage.getItem("user")
    if (userJSON == null) {
        nameOAuth2Validate();
    } else {
        var userJS = JSON.parse(userJSON)
        $("#user").html(userJS.name);
    }
});

// get name before autenticate credentials with GitHub token OAuth2
function nameOAuth2Validate() {
    $.ajax({
        url:`http://158.101.30.210:8080/OAuth2User`,
        type:'get',
        dataType:'json',
        success:function(request){
            if(Object.entries(request).length === 0){
                window.location.href="index.html";
            }else{
                $("#user").html(request.name);
            }  
            console.log(request)
        }
    });
}

// sidebar function
let arrow = document.querySelectorAll(".arrow");
for (var i = 0; i < arrow.length; i++) {
    arrow[i].addEventListener("click", (e) => {
        let arrowParent = e.target.parentElement.parentElement; //selecting main parent of arrow
        arrowParent.classList.toggle("showMenu");
    });
}
let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".bx-menu");
sidebarBtn.addEventListener("click", () => {
    sidebar.classList.toggle("close");
});

// logout method post /logout with ajax
function logoutPost() {
    $.ajax({
        url:`http://158.101.30.210:8080/logout`,
        type:'post',
        success:function(request) {
            console.log(request)
        }
    });
}

// logout with validations if it's sessionStorage or OAuth2
var logout = document.querySelectorAll("#logout")
var logout2 = document.getElementsByClassName("bx-power-off");
for (let i = 0; i < logout.length; i++) {
    logout[i].addEventListener("click", (e)=> {
        e.preventDefault();
        var userJSON = sessionStorage.getItem("user")
        if (userJSON == null){
            setTimeout(()=>{
                logoutPost();
                $("#user").html('');
                window.location.href="index.html";
            }, 1000)
        }else{
            sessionStorage.removeItem("user")
            setTimeout(()=> {
                Swal.fire({
                    title: 'Session Cerrada Correctamente',
                    icon: 'success',
                    showConfirmButton: false,
                })
                window.location.href="index.html";
            }, 1800)
        }
    })
}

// function ajax for get token OAuth2 avalability
$.ajaxSetup({
    beforeSend : function(xhr, settings) {
      if (settings.type == 'POST' || settings.type == 'PUT'
          || settings.type == 'DELETE') {
        if (!(/^http:.*/.test(settings.url) || /^https:.*/
          .test(settings.url))) {
          // Only send the token to relative URLs i.e. locally.
          xhr.setRequestHeader("X-XSRF-TOKEN",
            Cookies.get('XSRF-TOKEN'));
        }
      }
    }
});
