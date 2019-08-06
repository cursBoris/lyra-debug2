package ru.curs.demo;

import ru.curs.celesta.CallContext;
import ru.curs.lyra.dto.FormInstantiationParams;
import ru.curs.lyra.kernel.BasicGridForm;
import ru.curs.lyra.kernel.GridRefinementHandler;
import ru.curs.lyra.kernel.LyraFieldType;
import ru.curs.lyra.kernel.LyraFormField;
import ru.curs.lyra.kernel.annotations.FormField;
import ru.curs.lyra.kernel.annotations.FormParams;
import ru.curs.lyra.kernel.annotations.LyraForm;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@LyraForm(gridWidth = "95%", gridHeight = "470px",
        gridHeader = "<h5>Это хедер лира-грида</h5>",
        gridFooter = "<h5>Это футер лира-грида</h5>")
public class P1MainLyra extends BasicGridForm<Street4Cursor> {

    @FormParams
    private FormInstantiationParams params = null;

    //Constructor will be run only once: each form is a Spring's singleton Component
    public P1MainLyra(CallContext c, GridRefinementHandler changeNotifier/*, FormInstantiationParameters params*/) {
        super(c, changeNotifier);


/*
        this.params = params;
        System.out.println("CCCCCCCCCCCCCCCC44.P1MainLyra");
        if (params != null) {
            System.out.println(params.getClientParams());
        }
*/

        //First, we add to the form all the table's fields in the order they declared in SQL
        createAllBoundFields();

        getFieldsMeta().get("name").setCssStyle("white-space:nowrap;width:300px;text-align:left;");

        //Add a field to a form with default attributes (inherited from CelestaDoc or chosen by default)
        createField("field1");

        //Add a field to the form and then alter its caption
        LyraFormField f = createField("field2");
        f.setType(LyraFieldType.VARCHAR);
        f.setCaption("Unbound поле2");
        f.setVisible(true);
        f.setCssStyle("white-space:nowrap;width:300px;text-align:center;");
        f.setSortable(false);

        //      createAllUnboundFields();

    }

    @FormField(caption = "Unbound поле1",
            visible = true,
            cssStyle = "white-space:nowrap;width:320px;text-align:center;",
            sortable = false
    )
    public String getField1(CallContext ctx) {
        return "поле1_" + rec(ctx).getName();
    }

    @FormField
    public String getField2(CallContext ctx) {
        return "поле2_" + rec(ctx).getCode();
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

            //c.orderBy("name", "code");
            //c.orderBy("name");
            //c.orderBy("rnum");


            //c.setRange("rnum", 1, 68);
            //c.setRange("rnum", 7, 10);
            //c.setRange("rnum", -1, -5);


            getFormProperties().setFooter("<h5>refreshParams: " + refreshParams.toString() + ", date: " + LocalDateTime.now() + "</h5>");
        }


        return c;
    }



/*
    @Override
    public int getGridHeight() {
        return 50;
    }

    @Override
    public String getSummaryRow() {
        return null;
    }

    @Override
    public void beforeSending(BasicCursor basicCursor) {
        rec().setName("dd22");
    }
*/


}
