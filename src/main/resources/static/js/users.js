jQuery(document).ready(function() {
    let userTable, uid;

    let loadUserTbl = function() {
        uid = $('#userId').val();
        console.log("uid: " + uid);

        userTable = $('#userTable').DataTable({
            select: true,
            "ajax": {
                "url": "/getSingleUserData?userCardNumber=" + uid,
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

        $.get("/getUserBalance?userCardNumber=" + uid, function (data) {
            console.log("User " + uid + " has a balance of " + data);
            $('#userBalance').html("User balance: $" + data);
        });
    }

    $('#loadDataBtn').click(loadUserTbl);

    $('#userTable tbody').on( 'click', 'tr', function () {
        console.log( userTable.row( this ).data() );
    });

    $('#payBalanceBtn').click(function () {
        uid = $('#userId').val();
        console.log("uid: " + uid);
        $.get("/payBalance?userCardNumber=" + uid, function (data) {
            alert("Balance paid " + data + " for user # " + uid);
        });
    });

    let itemsTable = $('#itemsTable').DataTable({
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

});