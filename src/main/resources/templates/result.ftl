<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<#if (textF.title!"") == "" || (textF.text!"") == "" && noErrors??>
    titleが挿入されていません.
    <br>textが挿入されていません.
    <#else>
    ${textF.title}
    <br>${textF.text}

</#if>



</body>
</html>