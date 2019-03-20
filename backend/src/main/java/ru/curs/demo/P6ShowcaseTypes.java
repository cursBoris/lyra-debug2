package ru.curs.demo;

import org.json.JSONObject;
import ru.curs.celesta.CallContext;
import ru.curs.lyra.kernel.BasicGridForm;
import ru.curs.lyra.kernel.annotations.FormParams;
import ru.curs.lyra.kernel.annotations.LyraForm;
import ru.curs.lyra.service.FormInstantiationParameters;

import java.time.LocalDateTime;

@LyraForm(gridHeader = "<h5>'Showcase' типы столбцов</h5>")
public class P6ShowcaseTypes extends BasicGridForm<WebsitesVueCursor> {

    @FormParams
    private FormInstantiationParameters params = null;

    //Constructor will be run only once: each form is a Spring's singleton Component
    public P6ShowcaseTypes(CallContext c) {
        super(c);

        createAllBoundFields();
    }

    @Override
    public WebsitesVueCursor getCursor(CallContext callContext) {
        //sorting and filtering can also be performed here

        WebsitesVueCursor c = new WebsitesVueCursor(callContext);

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
