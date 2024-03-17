function init() {
    let highRelevance = document.querySelectorAll('[data-high-relevance]');
    highRelevance.forEach(item => {
        item.addEventListener('click', event => {
            let high = (item.dataset.highRelevance === 'true');
            item.dataset.highRelevance = !high;
        })
    });

    let highligthtedP = document.querySelectorAll('p[data-type="highlight"]');
    highligthtedP.forEach(item => {
        item.addEventListener('click', event => {
            let spans = item.querySelectorAll('span');
            spans.forEach(itemSpan => itemSpan.style.fontWeight = 900);
        })
    });
}

window.onload = function() {
    init();
}
