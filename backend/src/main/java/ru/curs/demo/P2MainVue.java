package ru.curs.demo;

import ru.curs.celesta.CallContext;
import ru.curs.lyra.dto.FormInstantiationParams;
import ru.curs.lyra.kernel.BasicGridForm;
import ru.curs.lyra.kernel.GridRefinementHandler;
import ru.curs.lyra.kernel.annotations.FormParams;
import ru.curs.lyra.kernel.annotations.LyraForm;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@LyraForm(gridWidth = "95%", gridHeight = "470px",
        gridHeader = "<h5>Это хедер лира-грида</h5>",
        gridFooter = "<h5>Это футер лира-грида</h5>")
public class P2MainVue extends BasicGridForm<Street4Cursor> {

    @FormParams
    private FormInstantiationParams params = null;

    private String oldSort;

    //Constructor will be run only once: each form is a Spring's singleton Component
    public P2MainVue(CallContext c, GridRefinementHandler changeNotifier) {
        super(c, changeNotifier);

        createAllBoundFields();
    }

    @Override
    public Street4Cursor getCursor(CallContext callContext) {
        //sorting and filtering can also be performed here

        Street4Cursor c = new Street4Cursor(callContext);

        System.out.println("LLLLLLLLLLLLLLL44.getCursor");
        if (params != null) {
            System.out.println(params.getClientParams());

            Map<String, Object> refreshParams = (Map<String, Object>) params.getClientParams().get("refreshParams");

            List<String> sort = (List) refreshParams.get("sort");
            String[] names = sort.stream().toArray(String[]::new);
            c.orderBy(names);

            getFormProperties().setFooter("<h5>refreshParams: " + refreshParams.toString() + ", date: " + LocalDateTime.now() + "</h5>");
        }

        return c;
    }


}
