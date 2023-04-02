window.onload = function () {
    var canvas = document.getElementById("canvas");

    //判断浏览器是否支持canvas
    if (canvas.getContext("2d")) {
        var context = canvas.getContext("2d");
    } else {
        alert("当前浏览器不支持canvas，请更换浏览器稍后再试")
    }
    //点击首页按钮进入介绍页面
    $("#backToHome").click(function () {
        $("#showCase").css("background-color", "rgba(255,255,255,0.8)");
        $("#exhibition").css("display", "block");
    });

    $("#sqlistNav").click(function () {

        //解除之前已绑定的事件
        $('#optionFirst').unbind("click");
        $('#optionSecond').unbind("click");
        //绘图背景
        $("#introduce").css("display", "none");
        $("#showCase").css("background-color", "rgba(255,255,255,1.0)");
        $("#exhibition").css("display", "block");
        //具体操作
        console.log($("#optionFirst"));
        $("#optionFirst").text("插入");
        $("#optionSecond").text("删除");
        $("#optionSecond").removeClass("btn-primary");
        $("#optionSecond").addClass("btn-danger");
        //绘制操作
        var index = 0;
        context.clearRect(0, 0, 900, 600);
        var Sqlist = [];


        //插入操作
        $("#optionFirst").click(function () {
            var pattern = /^(-)?\d+(\.\d+)?$/;

            if (Sqlist.length > 10) {
                alert("表已满，不能再插入");
            } else if (pattern.exec($("#inputElement").val()) == null || $("#inputElement").val() == "") {
                //使用正则表达式判断输入的内容是否为数字
                alert("请输入正确的数字")
            } else {
                //寻找要插入的位置
                var position = SqlistInFind(Sqlist, parseInt($("#inputElement").val()));
                console.log(position);
                //插入到指定位置
                Sqlist = SqlistInsert(Sqlist, position, parseInt($("#inputElement").val()));
                console.log(Sqlist);
                //清空输入框
                $("#inputElement").val("");

                //绘制操作
                //清空画布
                context.clearRect(0, 0, 900, 600);
                //依次绘制
                for (var i = 0; i < Sqlist.length; i++) {
                    context.save();
                    context.translate(62 * (i + 1), 0);
                    if (i === position) {
                        drawSqlist(context, Sqlist[i], "#FFFF00");
                    } else {
                        drawSqlist(context, Sqlist[i], "#FFFFFF");
                    }
                    context.restore();
                }
            }
        });
        //删除操作
        $("#optionSecond").click(function () {
            var pattern = /^(-)?\d+(\.\d+)?$/;
            console.log($("#inputElement").val());
            if (pattern.exec($("#inputElement").val()) == null || $("#inputElement").val() == "") {
                alert("请输入正确的待删除元素");
            } else if (Sqlist.length === 0) {
                alert("当前表中没有元素，请先添加元素后进行删除操作");
            } else {
                //开始删除
                var canDelete = false;
                for (var i = 0; i < Sqlist.length; i++) {
                    //判断是否可以进行操作
                    if (Sqlist[i] === parseInt($("#inputElement").val())) {
                        Sqlist = SqlistDelete(Sqlist, parseInt($("#inputElement").val()), i);
                        canDelete = true;
                        //绘制元素
                        context.clearRect(0, 0, 900, 600);
                        for (var j = 0; j < Sqlist.length; j++) {
                            context.save();
                            context.translate(62 * (j + 1), 0);
                            drawSqlist(context, Sqlist[j], "#FFFFFF");
                            context.restore();
                        }
                    }
                }
                if (canDelete === false) {
                    alert("表中不存在该元素，请验证后再进行插入操作");
                }
                //清空输入框
                $("#inputElement").val("");
                console.log(Sqlist);
            }
        })
    })

    /*
*****************************************链表***************************************************
*/
    $("#lnodeNav").click(function () {
        //解除之前已绑定的事件
        $('#optionFirst').unbind("click");
        $('#optionSecond').unbind("click");
        context.clearRect(0,0,900,600);
        //绘图背景
        $("#introduce").css("display", "none");
        $("#showCase").css("background-color", "rgba(255,255,255,1.0)");
        $("#exhibition").css("display", "block");
        //具体操作
        console.log($("#optionFirst"));
        $("#optionFirst").text("头插法");
        $("#optionSecond").text("尾插法");

        //头插法
        var LNode = [];
        //drawLnodeItem(context,40,400,80,40,1,"#444","#fff","head",1);
        LNode[0]="head";

        context.clearRect(0,0,1000,500);
        //创建image对象
        var img = new Image();


        //头插法
        $("#optionFirst").click(function () {
            //绘制图像
            context.clearRect(0,0,400,400);
            img.src='../components/img/LNodeHead.png';
            img.onload = function(){
                context.drawImage(img,450-img.width/2,40);
                console.log(img.width);
            };


            var pattern = /^[a-z]+$/;

            if (LNode.length > 10){
                alert("表已满，不能再插入");
                $("#insertLNode").val("");
            } else if (pattern.exec($("#inputElement").val()) == null || $("#inputElement").val() == "") {
                //使用正则表达式判断输入的内容是否为大写字母
                alert("请输入正确的字母");
                $("#inputElement").val("");
            }
            else {
                //绘制过渡动画
                //LNode=["dd","dee","efe"];

                var times=4;
                //设置定时器完成动画效果
                var clock = setInterval(function () {
                    context.clearRect(0,399,900,200);
                    drawLnodeItem(context,40,400,80,40,1,"#444","#fff",LNode[0],3);
                    context.save();
                    //绘制后边几个元素，隔开164像素的距离
                    context.translate(times,0);
                    for(var j=1;j<LNode.length;j++){
                        if(j === LNode.length - 1){
                            drawLnodeItem(context,204,400,80,40,1,"#444","#fff",LNode[j],1);
                        } else {
                            drawLnodeItem(context,204,400,80,40,1,"#444","#fff",LNode[j],0);
                        }
                        context.translate(164,0);
                    }
                    //绘制要加入的元素
                    context.restore();
                    context.clearRect(203,318+times/2-10,122,10);
                    drawLnodeItem(context,204,318+times/2,80,40,1,"#444","#FFFF00",$("#inputElement").val(),2);
                    context.clearRect(203-40,318+times/2,40,82);
                    drawLineArrow(context,154,420,204,318+times/2+20);
                    if(LNode.length!=1){
                        context.clearRect(204,318+times/2+40,80,40);
                        drawLineArrow(context,154+164,318+times/2+20,164+40+times,420);

                    }

                    times+=10;
                    if (times >= 174){
                        clearInterval(clock);
                    }
                },100);

                //绘制最终结果
                setTimeout(function () {
                    console.log(LNode);
                    for(var i=LNode.length-1;i>0;i--){
                        LNode[i+1]=LNode[i];
                    }
                    LNode[1]=$("#inputElement").val();
                    console.log($("#inputElement").val());
                    //开始绘制，首先清空画布
                    context.clearRect(0,399,900,600);
                    //context.translate(40,0);
                    context.save();
                    context.translate(40,0);
                    drawLnodeItem(context,0,400,80,40,1,"#444","#fff",LNode[0],4);
                    for(var j=1;j<LNode.length;j++){
                        context.translate(164,0);
                        console.log(j);
                        if(j === LNode.length - 1){
                            drawLnodeItem(context,0,400,80,40,1,"#444","#fff",LNode[j],1);
                        } else {
                            drawLnodeItem(context,0,400,80,40,1,"#444","#fff",LNode[j],0);
                        }

                    }
                    context.restore();
                    $("#inputElement").val("");
                },3000)



            }
            //
        });
        //尾插法
        $("#optionSecond").click(function () {
            //绘制图像
            context.clearRect(0,0,400,400);
            img.src='../components/img/LNodeTail.png';
            img.onload = function(){
                context.drawImage(img,450-img.width/2,40);
                console.log(img.width);
            }


            var pattern = /^[a-z]+$/;

            if (LNode.length > 10){
                alert("表已满，不能再插入");
                $("#inputElement").val("");
            } else if (pattern.exec($("#inputElement").val()) == null || $("#inputElement").val() == "") {
                //使用正则表达式判断输入的内容是否为大写字母
                alert("请输入正确的字母");
                $("#inputElement").val("");
            }
            else {
                var times=0;
                var clockLnode = setInterval(function () {
                    context.clearRect(0,399,900,200);
                    //依次绘制最后一个元素之前的所有元素
                    context.save();
                    console.log(LNode);
                    //此时数组里还没有刚获取到的值
                    for(var i=0;i<LNode.length;i++)
                    {
                        if (i===0){
                            if(LNode.length===1){
                                //是第一个元素
                                drawLnodeItem(context,40,400,80,40,1,"#444","#fff",LNode[i],3);
                            } else{
                                drawLnodeItem(context,40,400,80,40,1,"#444","#fff",LNode[i],4);
                            }
                        }else if(i === LNode.length - 1){
                            drawLnodeItem(context,40,400,80,40,1,"#444","#fff",LNode[i],2);
                        } else {
                            drawLnodeItem(context,40,400,80,40,1,"#444","#fff",LNode[i],0);
                        }
                        context.translate(164,0);
                    }
                    context.restore();
                    context.clearRect(204*(LNode.length),399,122,10);
                    drawLnodeItem(context,164*(LNode.length)+times,400,80,40,1,"#444","#FFFF00",$("#inputElement").val(),2);
                    //context.clearRect(164*(LNode.length)-40,499,40,40);
                    drawLineArrow(context,164*(LNode.length),400+20,164*(LNode.length)+times,400+20);
                    times+=5;
                    if (times >= 40){
                        clearInterval(clockLnode);
                    }
                },100);

                //绘制过渡动画
                setTimeout(function () {
                    LNode[LNode.length]=$("#inputElement").val();
                    console.log(LNode);
                    //开始绘制，首先清空画布
                    context.clearRect(0,399,900,600);
                    context.save();
                    context.translate(40,0);
                    drawLnodeItem(context,0,400,80,40,1,"#444","#fff",LNode[0],4);
                    for(var j=1;j<LNode.length;j++){
                        context.translate(164,0);
                        console.log(j);
                        if(j === LNode.length - 1){
                            drawLnodeItem(context,0,400,80,40,1,"#444","#fff",LNode[j],1);
                        } else {
                            drawLnodeItem(context,0,400,80,40,1,"#444","#fff",LNode[j],0);
                        }

                    }
                    context.restore();
                    $("#inputElement").val("");
                },3000);

            }
        })

    })
};