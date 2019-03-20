package ru.curs.demo;

import org.json.JSONObject;
import ru.curs.celesta.CallContext;
import ru.curs.lyra.kernel.BasicGridForm;
import ru.curs.lyra.kernel.annotations.FormField;
import ru.curs.lyra.kernel.annotations.FormParams;
import ru.curs.lyra.kernel.annotations.LyraForm;
import ru.curs.lyra.service.FormInstantiationParameters;

import java.time.LocalDateTime;

@LyraForm(gridWidth = "95%", gridHeight = "470px",
        gridHeader = "<h5>Задание css для строки грида</h5>")
public class P8CssRow extends BasicGridForm<Street4Cursor> {

    @FormParams
    private FormInstantiationParameters params = null;

    //Constructor will be run only once: each form is a Spring's singleton Component
    public P8CssRow(CallContext c) {
        super(c);

        //First, we add to the form all the table's fields in the order they declared in SQL
        createAllBoundFields();
    }

    @Override
    public Street4Cursor getCursor(CallContext callContext) {
        //sorting and filtering can also be performed here

        Street4Cursor c = new Street4Cursor(callContext);

        System.out.println("LLLLLLLLLLLLLLL44.getCursor");
        if (params != null) {
            System.out.println(params.getClientParams());

            JSONObject refreshParams = (JSONObject) (new JSONObject(params.getClientParams().get("context"))).get("refreshParams");
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


    @FormField
    public String getRecordProperties(CallContext callContext) {

        JSONObject prop = new JSONObject();

        prop.put("rowstyle", "jslivegrid-record-bold jslivegrid-record-italic");

        return prop.toString();

    }


}
