$(document).ready(function () {
    init();
});

function init() {
    var products = ["Produto A", "Produto B", "Produto C", "Produto D", "Produto E"];

    for (var i = 0; i < 20; i++) {
        var product = products[Math.floor(Math.random() * products.length)];
        var quantity = Math.floor(Math.random() * 100) + 1;
        var value = (Math.random() * 100).toFixed(2);

        $('table[class="table table-bordered"] tbody');
        var row = $('<tr>');
        $('<td>').text(product).appendTo(row);
        $('<td>').text(quantity).appendTo(row);
        $('<td>').text(value).appendTo(row);
        $('table[class="table table-bordered"] tbody').append(row);
    }
}