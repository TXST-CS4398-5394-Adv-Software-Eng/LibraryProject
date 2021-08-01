jQuery(document).ready(function() {
    let userTbl, uid;

    let loadUserTbl = function() {
        uid = $('#userId').val();
        console.log("uid: " + uid);

        userTbl = $('#userTable').DataTable({
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
    }

    $('#loadDataBtn').click(loadUserTbl);

    $('#itemsTable tbody').on( 'click', 'tr', function () {
        console.log( itemsTable.row( this ).data() );
    } );

});