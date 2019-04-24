package ru.curs.demo;

import ru.curs.celesta.CallContext;
import ru.curs.lyra.dto.FormInstantiationParams;
import ru.curs.lyra.kernel.BasicGridForm;
import ru.curs.lyra.kernel.annotations.FormField;
import ru.curs.lyra.kernel.annotations.FormParams;
import ru.curs.lyra.kernel.annotations.LyraForm;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

import static java.text.DateFormat.*;

@LyraForm(gridWidth = "95%", gridHeight = "470px",
        gridHeader = "<h5>'Лира' типы столбцов, Unbound столбцы</h5>")
public class P5LyraTypes extends BasicGridForm<Street4Cursor> {

    @FormParams
    private FormInstantiationParams params = null;

    //Constructor will be run only once: each form is a Spring's singleton Component
    public P5LyraTypes(CallContext c) {
        super(c);

        createField("field1");
        createField("field2");
        createField("field3");
        createField("field41");
        createField("field42");
        createField("field51");
        createField("field52");
        createField("field53");
        createField("field54");

//        createAllUnboundFields();
    }

    @FormField(caption = "VARCHAR",
            visible = true,
            cssStyle = "white-space:nowrap;width:100px;text-align:left;")
    public String getField1(CallContext ctx) {
        return rec().getName();
    }

    @FormField(caption = "INT",
            visible = true,
            cssStyle = "white-space:nowrap;width:50px;text-align:right;")
    public int getField2(CallContext ctx) {
        return rec().getRnum();
    }

    @FormField(caption = "BIT",
            visible = true,
            cssStyle = "white-space:nowrap;width:50px;text-align:right;")
    public boolean getField3(CallContext ctx) {
        return true;
    }


    @FormField(caption = "REAL_1",
            visible = true,
            cssStyle = "white-space:nowrap;width:100px;text-align:right;",
            scale = 1)
    public double getField41(CallContext ctx) {
        return rec().getRnum() + 0.1234567;
    }

    @FormField(caption = "REAL_3",
            visible = true,
            cssStyle = "white-space:nowrap;width:100px;text-align:right;",
            scale = 3,
            decimalSeparator = ".",
            groupingSeparator = "")
    public double getField42(CallContext ctx) {
        return rec().getRnum() + 0.1234567;
    }


    @FormField(caption = "DATETIME_SHORT",
            visible = true,
            cssStyle = "white-space:nowrap;width:70px;text-align:center;",
            dateFormat = SHORT)
    public Date getField51(CallContext ctx) {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    @FormField(caption = "DATETIME_MEDIUM",
            visible = true,
            cssStyle = "white-space:nowrap;width:100px;text-align:center;",
            dateFormat = MEDIUM)
    public Date getField52(CallContext ctx) {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    @FormField(caption = "DATETIME_LONG",
            visible = true,
            cssStyle = "white-space:nowrap;width:150px;text-align:center;",
            dateFormat = LONG)
    public Date getField53(CallContext ctx) {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    @FormField(caption = "DATETIME_FULL",
            visible = true,
            cssStyle = "white-space:nowrap;width:150px;text-align:center;",
            dateFormat = FULL)
    public Date getField54(CallContext ctx) {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }


    @Override
    public Street4Cursor getCursor(CallContext callContext) {
        //sorting and filtering can also be performed here

        Street4Cursor c = new Street4Cursor(callContext);

        System.out.println("LLLLLLLLLLLLLLL44.getCursor");
        if (params != null) {
            System.out.println(params.getClientParams());

            Map<String, Object> refreshParams = (Map<String, Object>) params.getClientParams().get("refreshParams");
            String sort = (String) refreshParams.get("sort");
            System.out.println(sort);

            String[] names = sort.split(",");

            c.orderBy(names);

            //c.orderBy("name", "code");
            //c.orderBy("name");
            //c.orderBy("rnum");

            getFormProperties().setFooter("<h5>refreshParams: " + refreshParams.toString() + ", date: " + LocalDateTime.now() + "</h5>");
        }

        return c;
    }


}
