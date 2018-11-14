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

            <form method="POST" action="/post">
            title:
            <@spring.formInput "textF.title/>
            <@spring.formText "textF.text/>
                <form:textarea path="text" cols="30" rows="10">
                        aaa</form:textarea>
                <input type="submit" value="送信">
            </form:form>


        </div>


    </div>
</body>
</html>