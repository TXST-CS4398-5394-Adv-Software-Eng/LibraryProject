jQuery(document).ready(function() {
    let usersTable, itemsTable;

    usersTable = $('#usersTable').DataTable({
        select: true,
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

    $('#usersTable tbody').on( 'click', 'tr', function () {
        console.log( usersTable.row( this ).data() );
    } );


    itemsTable = $('#itemsTable').DataTable({
        select: true,
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

    $('#itemsTable tbody').on( 'click', 'tr', function () {
        console.log( itemsTable.row( this ).data() );
    });

    $('#updateBalanceBtn').click( function () {
        $.get("/updateBalances", function (data) {
           console.log(data);
        });
    });
});