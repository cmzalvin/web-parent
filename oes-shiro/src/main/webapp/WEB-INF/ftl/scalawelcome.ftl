<html>
<head>
    <title></title>
    <script type="text/javascript" src="${jsRoot}jquery.js"></script>
</head>
<body>
<div id="msg">${msg}</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        alert("aaa");
        $("#msg").css({"color": "#ff0011", "background": "blue"})
    });
</script>
</html>