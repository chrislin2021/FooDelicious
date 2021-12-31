<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<body>
<h1 class="tableName">
    會員列表
    <span class="littleName">Member List</span>
</h1>
<form action="" method="post">
    <div class="col-sm-2">
        <input class="keyWord keyWord1" type="text" name="accKeyWord" placeholder="請輸入帳號關鍵字...">
        <input class="keyWord btn btn-outline-secondary" type="submit" value="查詢" />
    </div>
</form>

<section class="content">
        <div class="col-xs-12">
            <table id="" class='table table-striped table-hover '>
                <thead>
                <tr>
                    <th class="col col1 table-primary">會員編號</th>
                    <th class="col col2 table-primary">會員帳號</th>
                    <th class="col col3 table-primary">會員照片</th>
                    <th class="col col4 table-primary">帳號狀態</th>
                    <th class="col col5 table-primary">會員姓名</th>
                    <th class="col col6 table-primary">會員性別</th>
                    <th class="col col7 table-primary">會員coin</th>
                    <th class="col col8 table-primary">會員折扣</th>
                    <th class="col col9 table-primary">會員email</th>
                    <th class="col col10 table-primary">會員電話</th>
                    <th class="col col11 table-primary">會員地址</th>
                    <th class="col col12 table-primary">會員生日</th>
                    <th class="col col13 table-primary">註冊日期</th>
                    <th class="col col14 table-primary">更新</th>
                    <th class="col col15 table-primary">刪除</th>
                </tr>
                </thead>
                <tbody id="members"></tbody>
            </table>
    </div>
</section>
</div>
<%--<script language="javascript" type="text/javascript">--%>
<%--    function delConfirm(memid) {--%>
<%--        if(confirm("確定要刪除嗎")){--%>
<%--            window.location.href="MemDelete?memid="+memid;--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

<script>
    const memberUrl = "http://localhost:8080/bkmembers"
    const xhr = new XMLHttpRequest();
    xhr.open('get',memberUrl,true);
    xhr.send();
    let memberData='';
    xhr.onload = function(){
        memberData = JSON.parse(xhr.responseText);
        let txt = "<tr>";
        for (let i = 0; i < memberData.length; i++) {
            txt += "<td class='align-middle'>"+memberData[i].memberId+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].bkAccount.account+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberPic+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].bkAccount.accountStatus+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberName+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberGender+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberCoin+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].discount+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberMail+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberPhone+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberAddress+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberBirth+"</td>"
            let newDate = new Date(memberData[i].bkAccount.registerDate);
            let register = newDate.toLocaleString();
            txt += "<td class='align-middle'>"+register+"</td>"
            txt += '<td class="align-middle">'+
                        '<form method="post" action="MemUpdate">'+
                            '<input type="hidden" type="text" name="memupd" value=?>'+
                            '<input id="updateBtn" class="btn btn-outline-primary" type="submit" value="更新">'+
                        '</form>'+
                    '</td>'
            txt += '<td class="mdata">'+
                        '<form method="post" action="">'+
                            '<input type="hidden" type="text" name="empdel" value=?>'+
                            '<input id="delBtn" class="btn btn-outline-danger" type="button" value="刪除" onclick="">'+
                        '</form>'+
                    '</td></tr>'
        }
        $("#members").html(txt);
    }

</script>
</body>

