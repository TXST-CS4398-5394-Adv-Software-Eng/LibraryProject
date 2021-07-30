jQuery(document).ready(function() {
    let usersTable, itemsTable;

    usersTable = $('#usersTable').DataTable({
        select: {
            style: 'single'
        },
        "ajax": {
            "url": "/getUserData",
            "dataSrc": ""
        },
        "columns": [
            { data: "card.cardNumber", title: "Card ID" },
            { data: "name", title: "Name" },
            { data: "address", title: "Address" },
            { data: "phoneNum", title: "Phone #" },
            { data: "balance", title: "Balance" }
        ]
    });


    itemsTable = $('#itemsTable').DataTable({
        select: {
            style: 'single'
        },
        "ajax": {
            "url": "/getItemData",
            "dataSrc": ""
        },
        "columns": [
            { data: "itemNumber", title: "Item #" },
            { data: "author", title: "Author" },
            { data: "title", title: "Title" },
            { data: "genre", title: "Genre" },
            { data: "publisher", title: "Publisher" }
        ]
    });

});