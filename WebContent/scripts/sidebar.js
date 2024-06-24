document.addEventListener("DOMContentLoaded", function() {
    var sidebar = document.getElementById("sidebar");
    var mainContent = document.getElementById("main-content");
    var toggleButton = document.getElementById("toggleButton");

    toggleButton.addEventListener("click", function() {
        if (sidebar.style.left === "0px") {
            sidebar.style.left = "-250px";
            mainContent.classList.add("collapsed");
        } else {
            sidebar.style.left = "0px";
            mainContent.classList.remove("collapsed");
        }
    });
});