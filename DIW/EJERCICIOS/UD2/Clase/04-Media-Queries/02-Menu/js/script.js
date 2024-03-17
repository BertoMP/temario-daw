window.addEventListener("load", arrancaMenu);

function arrancaMenu() {
    const menu = document.querySelector('.menu-responsive');
    menu.addEventListener('click', despliegaMenu);
}

function despliegaMenu() {
    document.querySelector('nav>ul').classList.toggle('desplegar');
}

