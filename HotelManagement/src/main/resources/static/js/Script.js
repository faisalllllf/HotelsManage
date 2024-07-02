



function handleClick() {
    

    // Using jQuery to manipulate the CSS display property
   
    
   
      $('#newRoleAddDiv').css("display", "block");
       $("#newaddbutton").css("display", "none");
   
      
   
}

function addNewRoleFinal() {
	 alert("Are you sure want to add new Role");
	 
	var customTable = document.getElementById("newRoleByAdmin").value;
	console.log("rolenew"+customTable);
	
	var select = $('#Category');
	console.log("Category"+Category);
	
/*
 * var option = document.createElement("option"); option.text = customTable;
 * 
 * option.value = customTable; select.add(option);
 * 
 */
	
	 $("#Category").append(new Option(customTable));
	
	$('#newRoleAddDiv').css("display", "none");
    $("#newaddbutton").css("display", "none");
}



















const body = document.querySelector("body");
const darkLight = document.querySelector("#darkLight");
const sidebar = document.querySelector(".sidebar");
const submenuItems = document.querySelectorAll(".submenu_item");
const sidebarOpen = document.querySelector("#sidebarOpen");
const sidebarClose = document.querySelector(".collapse_sidebar");
const sidebarExpand = document.querySelector(".expand_sidebar");
sidebarOpen.addEventListener("click", () => sidebar.classList.toggle("close"));

sidebarClose.addEventListener("click", () => {
  sidebar.classList.add("close", "hoverable");
});
sidebarExpand.addEventListener("click", () => {
  sidebar.classList.remove("close", "hoverable");
});

sidebar.addEventListener("mouseenter", () => {
  if (sidebar.classList.contains("hoverable")) {
    sidebar.classList.remove("close");
  }
});
sidebar.addEventListener("mouseleave", () => {
  if (sidebar.classList.contains("hoverable")) {
    sidebar.classList.add("close");
  }
});

darkLight.addEventListener("click", () => {
  body.classList.toggle("dark");
  if (body.classList.contains("dark")) {
    document.setI
    darkLight.classList.replace("bx-sun", "bx-moon");
  } else {
    darkLight.classList.replace("bx-moon", "bx-sun");
  }
});

submenuItems.forEach((item, index) => {
  item.addEventListener("click", () => {
    item.classList.toggle("show_submenu");
    submenuItems.forEach((item2, index2) => {
      if (index !== index2) {
        item2.classList.remove("show_submenu");
      }
    });
  });
});



if (window.innerWidth < 768) {
  sidebar.classList.add("close");
} else {
  sidebar.classList.remove("close");
}



