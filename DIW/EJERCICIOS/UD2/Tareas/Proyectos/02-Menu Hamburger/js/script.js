const menu = document.getElementById('menu');
menu.addEventListener('click', despliega);

function despliega() {
    menu.classList.toggle('activado');
}