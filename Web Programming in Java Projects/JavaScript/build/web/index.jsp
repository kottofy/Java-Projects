<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            BODY {font-family:sans-serif}
            .quote {padding:20px 20px 20px 20px; border:medium solid green;
            font-family:cursive}
            .quote2 {padding:20px 20px 20px 20px; border:medium solid purple;
            font-family:cursive}

        </style>
        <title>JavaScript Practice</title>
        <script type="text/javascript">

            /*JQUERY...FADE TECHNIQUE TO MAKE IT LESS PRIMITIVE*/
            /*ADD <QUOTES> <QUOTE0>...</QUOTE4></QUOTES> IN XML*/

            //missing something here
            //can also replace beginRoll... with rollQuote so it only calls once
            $(document).ready(beginRollingQuote);

            var ROLLING_INTERVAL=4000; //same as 4 seconds
            var N_QUOTES=5;
            var currentQuote=0;

            /*CHANGE THE QUOTE EVERY ROLLING_INTERVAL MS*/
            function beginRollingQuote()
            {
                //make sure to not have alert boxes in calling function
                setInterval(rollQuote, ROLLING_INTERVAL);
            }

            /*CHANGE TO THE NEXT QUOTE, ROLLING BACK TO START IF
             *CURRENTQUOTE IS N_QUOTES=1*/
            function rollQuote()
            {
                //BLAH BLAH BLAH
            }

            /*INSERT AJAX RESPONSE INTO DOCUMENT*/
            function handleAjaxResponse(data)
            {
                currentQuote = (++currentQuote)%N_QUOTES;
                selector = "quote"+currentQuote;
                theQuote = $(data).find(selector).text();
                spanObj = document.getElementById("quote");
                textNode = spanObj.firstChild;
                textNode.data=theQuote;
//                $("#quote").firstChild.data=$(data).find("quote"+currentQuote);
            }

            function changeStyle()
            {
                spanObj = document.getElementById("quote");
                spanObj.className = "quote2";

                //ANYTHING INSIDE AN IF STMT IN JS WILL
                //RETURN TRUE AS LONG AS NOT NULL OR "0"
                if (spanObj) 
                    alert("found the span Obj" + spanObj.className + ", Node Type: " + spanObj.nodeType);
            }
            function changeContent()
            {
                spanObj = document.getElementById("quote");
                child = spanObj.firstChild;
                var text = document.createTextNode("Blah Blah Blah");

                if (child)  //if (child) checks to see if the child is null
                    {
                        child.data="BLAAAAAAHHHHH";

                        //verify that child node is 3 bc it's a text node
                        alert("found child " + child.nodeType);

                        /* ???????? */

                    }
                if (spanObj)
                    alert("found the spanObj, node type is " + spanObj.nodeType);
            }
        </script>
    </head>
    <body>
        <h1>JavaScript Practice</h1>
        <p>Click the buttons to change the style or substance of our
        daily  quote.</p>
        <h3>Daily Quote</h3>
        <div id="quote_div" style="padding-top:20px">
            <span id="quote" class="quote1">She got her looks from her father.
                He's a plastic surgeon. -- Groucho Marx.</span>
            <p>
                <input type="button" onclick="changeStyle()" value="Change Style">
                <input type="button" onclick="changeContent()" value="Change Content">
            </p>
        </div>
    </body>
</html>
