<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>

        .outer {
            width: 50%;
            margin-left: 25%;
            margin-top: 15%;
        }

        .row{
            max-width:500px;
            width:50%;
            display:flex;
            flex-direction:row;
            justify-content:space-around;
        }

        .button {
            text-align: right;
            padding: 10px;
        }
    </style>
</head>
<body>
    <form action="welcome" method="post">
        <header></header>
        <div class="outer">
            <fieldset>
                <legend style="color:blue;">Login</legend>
                <div>
                    <div class="form-group row" style="padding:20px">
                        <label class="col-sm-2 col-form-label">Username</label>

                        <input type="text" class="form-control" placeholder="Username" name="username" minlength="5" maxlength="50">

                    </div>
                    <div class="form-group row" style="padding:20px">
                        <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>

                        <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password" minlength="5" maxlength="50">

                    </div>
                    <div class="button">
                        <input type="submit" value="Login" />
                    </div>
                </div>
            </fieldset>
        </div>
        <footer></footer>
    </form>

</body>
</html>