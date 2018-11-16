<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="\css\navigation.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<div id="home">
        <a id="plusimg" href="input">
            <img src="/css/plus.png" alt="追加">
        </a>
    <div class="dtable">
    
    <div class="dtable_c">
        <div class="folder" id="1">
            フォルダ1
        </div>
        <div class="folder" id="2">フォルダ2</div>
        <div class="folder" id="3">フォルダ3</div>
    </div>
    <div class="dtable_text">
        <span id="title">GET STARTED!!</span>
        <div>
            <div class="menu" id="menu1">
                <br>aaaaaaaaaaaaaaaaaaaaaaa
                <br>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                <br>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                <br>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
            </div>
            <div class="menu" id="menu2">
                <br>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
                <br>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
                <br>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
                <br>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
                <br>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
            </div>
        </div>
    </div>
    
    </div>
    
    </div>
    <script>
        var befor_id = 0;
        $(function () {
            $('div.folder').click(function () {
                var id = $(this).attr("id");
                if (befor_id !== id) {
                    $('#menu' + befor_id).hide();
                }
                $('#menu' + id).toggle();
                befor_id = id;
            });
        });
    </script>
    
    </body>
</html>