<#import "/spring.ftl" as spring/>

<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>入力画面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>

<body>
    <div class="dtable">
        <div class="dtable_text">
        <@spring.bind "textF"/>

        <div class="dtable_text">
            <form method="POST" action="/post">
            <span id="title">
            <@spring.formInput "textF.title"/>
            </span>
            <p class="text">
            <@spring.formTextarea "textF.text"/>
            </p>
            <input type="submit" value="送信">
            </form>
        </div>
        </div>
    </div>
</body>
</html>