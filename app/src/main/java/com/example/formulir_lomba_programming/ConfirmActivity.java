import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class ConfirmActivity extends AppCompatActivity {
    TextView tvNama, tvJenisKelamin, tvNoWhatsapp, tvAlamat,
            tvTanggal;
    Button btnTanggal, btnKonfirmasi;
    String nama, jenisKelamin, noWhatsapp, alamat;
    String choosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        tvNama = findViewById(R.id.tv_nama);
        tvJenisKelamin = findViewById(R.id.tv_jenis_kelamin);
        tvNoWhatsapp = findViewById(R.id.tv_no_whatsapp);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTanggal = findViewById(R.id.tv_tanggal);
        btnTanggal = findViewById(R.id.btn_tanggal);
        btnKonfirmasi = findViewById(R.id.btn_konfirmasi);
        Intent terima = getIntent();
        nama = terima.getStringExtra("varNama");
        noWhatsapp = terima.getStringExtra("varNoWhatsapp");
        alamat = terima.getStringExtra("varAlamat");
        jenisKelamin =
                terima.getStringExtra("varJenisKelamin");
        tvNama.setText(nama);
        tvNoWhatsapp.setText(noWhatsapp);
        tvAlamat.setText(alamat);
        tvJenisKelamin.setText(jenisKelamin);
        btnTanggal.setOnClickListener(new
                                              View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {
                                                      DialogFragment frgTanggal = new
                                                              DatePickerFragment();
                                                      frgTanggal.show(getSupportFragmentManager(),
                                                              "datePicker");
                                                  }
                                              });
        btnKonfirmasi.setOnClickListener(new
                                                 View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View view) {
                                                         AlertDialog.Builder dialog = new
                                                                 AlertDialog.Builder(ConfirmActivity.this);
                                                         dialog.setTitle("Perhatian");
                                                         dialog.setMessage("Apakah Data yang Anda Isi Benar ?");
                                                                 dialog.setPositiveButton("Ya", new
                                                                         DialogInterface.OnClickListener() {
                                                                             @Override
                                                                             public void onClick(DialogInterface
                                                                                                         dialogInterface, int i) {
                                                                                 Toast.makeText(ConfirmActivity.this,
                                                                                         "Terimakasih, Pendaftaran Anda Berhasil !",
                                                                                         Toast.LENGTH_SHORT).show();
                                                                                 finish();
                                                                             }
                                                                         });
                                                         dialog.setNegativeButton("Tidak", new
                                                                 DialogInterface.OnClickListener() {
                                                                     @Override
                                                                     public void onClick(DialogInterface
                                                                                                 dialogInterface, int i) {
                                                                     }
                                                                 });
                                                         dialog.show();
                                                     }
                                                 });
    }
    public void processDatePickerResult(int year, int month,
                                        int day){
        String tahun = Integer.toString(year);
        String bulan = Integer.toString(month+1);
        String tanggal = Integer.toString(day);
        choosenDate = tanggal + " / " + bulan + " / " +
                tahun;
        tvTanggal.setText(choosenDate);
    }
}
