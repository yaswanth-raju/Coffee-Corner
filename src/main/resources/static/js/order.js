document.getElementById('orderForm').addEventListener('submit', function(event) {
event.preventDefault();

let formData = new FormData(this);
let mainProducts = [];
let productAddons = {};

// Get all selected products
this.querySelectorAll('input[name="mainProducts"]:checked').forEach(input => {
    mainProducts.push(parseInt(input.value));
    productAddons[input.value] = [];
});

// Get all selected addons for each product
this.querySelectorAll('select[multiple]').forEach(select => {
    let productId = select.name.split('_')[1];
    let selectedAddons = Array.from(select.selectedOptions).map(option => parseInt(option.value));
    if (selectedAddons.length > 0) {
        productAddons[productId] = selectedAddons;
    }
});

let orderData = {
    mainProducts: mainProducts,
    productAddons: productAddons
};

fetch('/orders', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(orderData)
}).then(response => {
    if (response.ok) {
        alert('Order placed successfully!');
    } else {
        alert('Failed to place order.');
    }
}).catch(error => {
    alert('An error occurred: ' + error.message);
});
});