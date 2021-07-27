jQuery(document).ready(function() {
    let usersTable, itemsTable;

    $('#usersTable').DataTable({
        "ajax": {
            "url": "/getUserData",
            "dataSrc": ""
        },
        "columns": [
            { "data": "card.cardNumber" },
            { "data": "name" },
            { "data": "address" },
            { "data": "phoneNum" },
            { "data": "balance" }
        ]
    });


    itemsTable = $('#itemsTable').DataTable({
        "scrollX": true,
        "sScrollXInner": "100%",
        "ajax": {
            "url": "/getItemData",
            "dataSrc": ""
        },
        "columns": [
            {data: "itemNumber", title: "Item #" },
            {data: "author", title: "Author" },
            {data: "title", title: "Title" },
            {data: "genre", title: "Genre" },
            {data: "publisher", title: "Publisher" }
        ]
    });

});