<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="\css\navigation.css">
    <link rel="stylesheet" type="text/css" href="\css\tooltip.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/javascript/main.js"></script>

    <!-- jQuery Modal -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
</head>

<body>


    <!-- Modal HTML embedded directly into document -->
    <div id="addFolder" class="modal">
        <form action="./" method="post">
            <p>
                追加するフォルダ名:
                <input type="text" style="width:250px;">
            </p>
            <input type="submit" value="OK">
        </form>
        <a href="#" rel="modal:close">Close</a>
    </div>
    <div id="addFile" class="modal">
        <form action="./" method="POST">
            追加するフォルダを選択:
            <select name=”month”>
                <option value=”jan”>1月</option>
                <option value=”feb”>2月</option>
                <option value=”mar”>3月</option>
            </select>
            <div>
                追加するファイル名:
                <input type="text" style="width:250px;">
            </div>
            <input type="submit" value="OK">
        </form>


        <a href="#" rel="modal:close">Close</a>
    </div>


    <div id="home">
        <div id="plusimg">
            <a class="clickToolTip" href="#plus">
                <img src="/css/plus.png" alt="追加">
            </a>
            <p id="plus" class="toolTip invisible">
                <a href="#addFolder" rel="modal:open">フォルダを追加する</a>
                <br><a href="#addFile" rel="modal:open">ファイルを追加する</a>
            </p>

        </div>

        <div class="dtable">

            <div class="dtable_c">
                <div class="folder" id="1">
                    フォルダ1
                </div>
                <div class="folder" id="2">フォルダ2</div>
                <div class="folder" id="3">フォルダ3</div>
            </div>
            <div class="dtable_text">
                    <!-- <span id="title">${title}</span>
                    <hr>
                    <p class="text">${text}</p> -->
                    <#if (textF.title!"")=="" || (textF.text!"")=="">
                        titleが挿入されていません.
                        <br>textが挿入されていません.
                        <#else>
                            ${textF.title}
                            <br>${textF.text}
                    
                    </#if>
                    <a href="edit">編集</a>
                    </div>
                    
                    </div>
                    
                    </div>
                    
                    
                    </body>
</html>