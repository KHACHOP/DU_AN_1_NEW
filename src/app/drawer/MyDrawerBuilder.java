package app.drawer;

import app.form.Bill;
import app.form.Chart;
import app.form.Customer;
import app.form.DetailProduct;
import app.form.ProductAttributes;
import app.form.Products;
import app.form.Sell;
import app.form.Staff;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import app.form.TestForm;
import app.form.Voucher;
import app.main.Main;
import raven.swing.AvatarIcon;
import app.tabbed.WindowsTabbed;

/**
 *
 * @author RAVEN
 */
public class MyDrawerBuilder extends SimpleDrawerBuilder {

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/app/image/profile.jpg"), 80, 80, 1000)) // Điều chỉnh kích thước ảnh là 80x80
                .setTitle("Tshirt");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~MAIN~"},
            {"Home"},
            {"Sell"},
            {"~WEB APP~"},
            {"Product", "Products", "Detail Product", "Product Attributes"},
            {"Bill"},
            {"Voucher"},
            {"Staff"},
            {"Customer"},
            {"~OTHER~"},
            {"Charts"},
            {"Logout"}};

        String icons[] = {
            "home.svg",
            "sell.svg",
            "product.svg",
            "bill.svg",
            "voucher.svg",
            "staff.svg",
            "customer.svg",
            "chart.svg",
            "logout.svg"};

        return new SimpleMenuOption()
                .setMenus(menus)
                .setIcons(icons)
                .setBaseIconPath("app/drawer/icon")
                .setIconScale(0.45f)
                .addMenuEvent(new MenuEvent() {
                    @Override
                    public void selected(MenuAction action, int index, int subIndex) {
                        if (index == 0) {
                            WindowsTabbed.getInstance().addTab("Home", new TestForm());
                        } else if (index == 1) {
                            WindowsTabbed.getInstance().addTab("Sell", new Sell());
                        } else if (index == 2) {

                            if (subIndex == 1) {
                                WindowsTabbed.getInstance().addTab("Products", new Products());
                            } else if (subIndex == 2) {
                                WindowsTabbed.getInstance().addTab("Detail Product", new DetailProduct());
                            } else if (subIndex == 3) {
                                WindowsTabbed.getInstance().addTab("Product Attributes", new ProductAttributes());
                            }
                        } else if (index == 3) {
                            WindowsTabbed.getInstance().addTab("Bill", new Bill());
                        } else if (index == 4) {
                            WindowsTabbed.getInstance().addTab("Voucher", new Voucher());
                        } else if (index == 5) {
                            WindowsTabbed.getInstance().addTab("Staff", new Staff());
                        } else if (index == 6) {
                            WindowsTabbed.getInstance().addTab("Customer", new Customer());
                        } else if (index == 7) {
                            WindowsTabbed.getInstance().addTab("Chart", new Chart());
                        } else if (index == 8) {
                            Main.main.login();
                        }
                        System.out.println("Menu selected " + index + " " + subIndex);
                    }
                })
                .setMenuValidation(new MenuValidation() {
                    @Override
                    public boolean menuValidation(int index, int subIndex) {
//                        if(index==0){
//                            return false;
//                        }else if(index==3){
//                            return false;
//                        }
                        return true;
                    }

                });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                .setTitle("Project Shop Tshirt")
                .setDescription("Version 1.1.0");
    }

    @Override
    public int getDrawerWidth() {
        return 275;
    }
}
