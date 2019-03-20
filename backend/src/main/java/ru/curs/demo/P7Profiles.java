package ru.curs.demo;

import org.json.JSONObject;
import ru.curs.celesta.CallContext;
import ru.curs.lyra.kernel.BasicGridForm;
import ru.curs.lyra.kernel.LyraFormField;
import ru.curs.lyra.kernel.annotations.FormParams;
import ru.curs.lyra.kernel.annotations.LyraForm;
import ru.curs.lyra.service.FormInstantiationParameters;

import java.time.LocalDateTime;


@LyraForm(gridWidth = "95%", gridHeight = "470px",
        gridHeader = "<h5>Профайлы</h5>",
        visibleColumnsHeader = false,
        allowTextSelection = false)
public class P7Profiles extends BasicGridForm<Street4Cursor> {

    @FormParams
    private FormInstantiationParameters params = null;

    //Constructor will be run only once: each form is a Spring's singleton Component
    public P7Profiles(CallContext c) {
        super(c);

        LyraFormField f = createField("name");
        f.setCssStyle("font-size:1em;white-space:nowrap;width:400px;text-align:center;;color: white;background-color: cadetblue;");

        f = createField("rnum");
        f.setCssStyle("font-size:1em;white-space:nowrap;width:100px;text-align:center;color: blueviolet;background-color: red;");

        f = createField("code");
        f.setCssStyle("font-size:1em;white-space:nowrap;width:100px;text-align:center;color: blueviolet;background-color: orange;");

        f = createField("socr");
        f.setCssStyle("font-size:1em;white-space:nowrap;width:100px;text-align:center;color: blueviolet;background-color: black;");

        f = createField("gninmb");
        f.setCssStyle("font-size:1em;white-space:nowrap;width:100px;text-align:center;color: blueviolet;background-color: red;");

        f = createField("uno");
        f.setCssStyle("font-size:1em;white-space:nowrap;width:100px;text-align:center;color: blueviolet;background-color: orange;");

        f = createField("ocatd");
        f.setCssStyle("font-size:1em;white-space:nowrap;width:100px;text-align:center;color: blueviolet;background-color: cadetblue;");


        //createAllBoundFields();
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


}
