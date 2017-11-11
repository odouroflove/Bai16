package txt.com.bai16;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnDialog;
    Dialog dialog;
    private Button btnAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDialog = (Button) this.findViewById(R.id.btn_showDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdialog();
            }
        });
        btnAlertDialog = (Button) this.findViewById(R.id.btn_showAlertdialog);
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertdialog();
            }
        });
    }
    public void showdialog(){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Bạn đã like rồi, tiếp tục Love nào ;)");
        dialog.setContentView(R.layout.dialog_liked);
        dialog.setCancelable(false);
        Button btndongylike = (Button) dialog.findViewById(R.id.dongylike);
        Button btnkhongdongylike = (Button) dialog.findViewById(R.id.khongdongylike);
        btndongylike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Thanks!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btnkhongdongylike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, ":(", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void alertdialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Form User");
        builder.setMessage("Bạn có muốn thoát Ứng dụng Like");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Bạn đã đăng xuất thành công", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"Bạn đã đăng xuất thành công", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
