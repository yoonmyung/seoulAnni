package com.example.seoulapp1;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;

public class Activity3 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final int REQUEST_CODE_PERMISSIOINS = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.activity_action_bar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Intent intent = new Intent(this.getIntent());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng seoulCenter = new LatLng(37.551170, 126.988227);
        LatLng pos1 = new LatLng(37.502296, 127.064159);
        LatLng pos2 = new LatLng(37.490880, 127.038439);
        LatLng pos3 = new LatLng(37.509794, 127.043215);
        LatLng pos4 = new LatLng(37.511495, 127.028537);
        LatLng pos5 = new LatLng(37.499673, 127.057885);
        LatLng pos6 = new LatLng(37.483727, 127.046445);
        LatLng pos7 = new LatLng(37.491856, 127.087995);
        LatLng pos8 = new LatLng(37.526240, 127.133726);
        LatLng pos9 = new LatLng(37.541258, 127.125874);
        LatLng pos10 = new LatLng(37.539189, 127.146206);
        LatLng pos11 = new LatLng(37.530294, 127.122598);
        LatLng pos12 = new LatLng(37.551691, 127.127243);
        LatLng pos13 = new LatLng(37.545720, 127.141093);
        LatLng pos14 = new LatLng(37.549725, 127.146247);
        LatLng pos15 = new LatLng(37.550937, 127.142831);
        LatLng pos16 = new LatLng(37.552786, 127.133324);
        LatLng pos17 = new LatLng(37.531688, 127.139177);
        LatLng pos18 = new LatLng(37.635712, 127.018734);
        LatLng pos19 = new LatLng(37.652941, 127.011741);
        LatLng pos20 = new LatLng(37.640785, 127.013151);
        LatLng pos21 = new LatLng(37.636260, 127.030346);
        LatLng pos22 = new LatLng(37.639776, 127.027206);
        LatLng pos23 = new LatLng(37.627014, 127.027004);
        LatLng pos24 = new LatLng(37.639767, 127.025528);
        LatLng pos25 = new LatLng(37.629998, 127.017548);
        LatLng pos26 = new LatLng(37.532678, 126.848309);
        LatLng pos27 = new LatLng(37.536847, 126.833453);
        LatLng pos28 = new LatLng(37.552975, 126.848477);
        LatLng pos29 = new LatLng(37.541699, 126.834764);
        LatLng pos30 = new LatLng(37.531347, 126.839887);
        LatLng pos31 = new LatLng(37.557502, 126.843191);
        LatLng pos32 = new LatLng(37.528892, 126.848851);
        LatLng pos33 = new LatLng(37.534563, 126.860703);
        LatLng pos34 = new LatLng(37.541538, 126.844241);
        LatLng pos35 = new LatLng(37.558813, 126.810175);
        LatLng pos36 = new LatLng(37.553085, 126.833152);
        LatLng pos37 = new LatLng(37.541109, 126.848495);
        LatLng pos38 = new LatLng(37.479739, 126.931376);
        LatLng pos39 = new LatLng(37.470092, 126.935290);
        LatLng pos40 = new LatLng(37.475072, 126.965277);
        LatLng pos41 = new LatLng(37.468535, 126.937545);
        LatLng pos42 = new LatLng(37.474499, 126.977847);
        LatLng pos43 = new LatLng(37.479102, 126.941700);
        LatLng pos44 = new LatLng(37.482545, 126.907792);
        LatLng pos45 = new LatLng(37.485914, 126.919089);
        LatLng pos46 = new LatLng(37.480601, 126.957058);
        LatLng pos47 = new LatLng(37.478132, 126.951509);
        LatLng pos48 = new LatLng(37.467725, 126.937313);
        LatLng pos49 = new LatLng(37.556932, 127.090787);
        LatLng pos50 = new LatLng(37.547040, 127.090100);
        LatLng pos51 = new LatLng(37.532842, 127.075217);
        LatLng pos52 = new LatLng(37.567730, 127.084766);
        LatLng pos53 = new LatLng(37.559363, 127.087114);
        LatLng pos54 = new LatLng(37.546511, 127.071297);
        LatLng pos55 = new LatLng(37.534089, 127.066296);
        LatLng pos56 = new LatLng(37.539356, 127.066710);
        LatLng pos57 = new LatLng(37.539356, 127.066710);
        LatLng pos58 = new LatLng(37.560592, 127.080023);
        LatLng pos59 = new LatLng(37.542873, 127.083821);
        LatLng pos60 = new LatLng(37.489927, 126.852868);
        LatLng pos61 = new LatLng(37.489667, 126.886894);
        LatLng pos62 = new LatLng(37.493394, 126.894232);
        LatLng pos63 = new LatLng(37.493264, 126.819001);
        LatLng pos64 = new LatLng(37.499036, 126.829513);
        LatLng pos65 = new LatLng(37.502371, 126.881484);
        LatLng pos66 = new LatLng(37.497056, 126.889563);
        LatLng pos67 = new LatLng(37.506582, 126.853200);
        LatLng pos68 = new LatLng(37.491351, 126.883593);
        LatLng pos69 = new LatLng(37.495415, 126.839258);
        LatLng pos70 = new LatLng(37.452658, 126.904474);
        LatLng pos71 = new LatLng(37.462273, 126.910179);
        LatLng pos72 = new LatLng(37.476858, 126.891794);
        LatLng pos73 = new LatLng(37.460486, 126.908348);
        LatLng pos74 = new LatLng(37.469460, 126.906423);
        LatLng pos75 = new LatLng(37.440220, 126.905788);
        LatLng pos76 = new LatLng(37.470182, 126.897037);
        LatLng pos77 = new LatLng(37.456907, 126.895395);
        LatLng pos78 = new LatLng(37.657414, 127.067877);
        LatLng pos79 = new LatLng(37.628612, 127.056071);
        LatLng pos80 = new LatLng(37.672855, 127.083284);
        LatLng pos81 = new LatLng(37.661207, 127.074067);
        LatLng pos82 = new LatLng(37.621503, 127.083041);
        LatLng pos83 = new LatLng(37.624780, 127.073766);
        LatLng pos84 = new LatLng(37.622778, 127.061465);
        LatLng pos85 = new LatLng(37.650217, 127.037204);
        LatLng pos86 = new LatLng(37.638107, 127.042948);
        LatLng pos87 = new LatLng(37.654099, 127.038428);
        LatLng pos88 = new LatLng(37.647082, 127.037157);
        LatLng pos89 = new LatLng(37.663231, 127.030331);
        LatLng pos90 = new LatLng(37.669635, 127.046516);
        LatLng pos91 = new LatLng(37.669292, 127.032621);
        LatLng pos92 = new LatLng(37.653181, 127.048121);
        LatLng pos93 = new LatLng(37.678638, 127.043390);
        LatLng pos94 = new LatLng(37.639780, 127.038762);
        LatLng pos95 = new LatLng(37.580469, 127.053024);
        LatLng pos96 = new LatLng(37.578226, 127.070587);
        LatLng pos97 = new LatLng(37.574406, 127.039706);
        LatLng pos98 = new LatLng(37.583940, 127.034187);
        LatLng pos99 = new LatLng(37.591474, 127.055678);
        LatLng pos100 = new LatLng(37.573189, 127.050485);
        LatLng pos101 = new LatLng(37.589832, 127.047360);
        LatLng pos102 = new LatLng(37.567932, 127.066196);
        LatLng pos103 = new LatLng(37.587168, 127.049970);
        LatLng pos104 = new LatLng(37.514047, 126.944829);
        LatLng pos105 = new LatLng(37.484831, 126.969779);
        LatLng pos106 = new LatLng(37.498034, 126.953078);
        LatLng pos107 = new LatLng(37.494675, 126.930795);
        LatLng pos108 = new LatLng(37.510428, 126.945001);
        LatLng pos109 = new LatLng(37.504022, 126.933113);
        LatLng pos110 = new LatLng(37.512324, 126.939413);
        LatLng pos111 = new LatLng(37.512324, 126.939413);
        LatLng pos112 = new LatLng(37.476989, 126.979819);
        LatLng pos113 = new LatLng(37.504429, 126.941044);
        LatLng pos114 = new LatLng(37.499078, 126.931314);
        LatLng pos115 = new LatLng(37.486435, 126.907670);
        LatLng pos116 = new LatLng(37.560252, 126.901186);
        LatLng pos117 = new LatLng(37.546994, 126.935323);
        LatLng pos118 = new LatLng(37.568572, 126.908984);
        LatLng pos119 = new LatLng(37.562616, 126.917788);
        LatLng pos120 = new LatLng(37.577163, 126.897185);
        LatLng pos121 = new LatLng(37.549764, 126.945520);
        LatLng pos122 = new LatLng(37.555814, 126.942388);
        LatLng pos123 = new LatLng(37.564475, 126.921946);
        LatLng pos124 = new LatLng(37.541424, 126.949845);
        LatLng pos125 = new LatLng(37.548077, 126.945229);
        LatLng pos126 = new LatLng(37.593710, 126.949772);
        LatLng pos127 = new LatLng(37.580069, 126.934133);
        LatLng pos128 = new LatLng(37.573812, 126.935203);
        LatLng pos129 = new LatLng(37.598823, 126.947153);
        LatLng pos130 = new LatLng(37.597989, 126.949068);
        LatLng pos131 = new LatLng(37.585703, 126.923243);
        LatLng pos132 = new LatLng(37.568230, 126.946632);
        LatLng pos133 = new LatLng(37.559451, 126.957000);
        LatLng pos134 = new LatLng(37.564817, 126.954702);
        LatLng pos135 = new LatLng(37.470572, 127.041231);
        LatLng pos136 = new LatLng(37.504683, 127.020997);
        LatLng pos137 = new LatLng(37.489600, 126.991346);
        LatLng pos138 = new LatLng(37.479741, 126.985527);
        LatLng pos139 = new LatLng(37.472255, 127.045546);
        LatLng pos140 = new LatLng(37.545809, 127.044093);
        LatLng pos141 = new LatLng(37.559169, 127.034928);
        LatLng pos142 = new LatLng(37.560821, 127.030429);
        LatLng pos143 = new LatLng(37.561175, 127.045850);
        LatLng pos144 = new LatLng(37.592911, 127.035545);
        LatLng pos145 = new LatLng(37.604946, 127.024922);
        LatLng pos146 = new LatLng(37.589307, 127.022367);
        LatLng pos147 = new LatLng(37.599889, 127.013936);
        LatLng pos148 = new LatLng(37.614032, 127.043628);
        LatLng pos149 = new LatLng(37.617515, 127.055799);
        LatLng pos150 = new LatLng(37.486945, 127.132463);
        LatLng pos151 = new LatLng(37.493567, 127.146795);
        LatLng pos152 = new LatLng(37.496815, 127.148552);
        LatLng pos153 = new LatLng(37.503607, 127.103742);
        LatLng pos154 = new LatLng(37.498670, 127.094889);
        LatLng pos155 = new LatLng(37.510092, 127.123000);
        LatLng pos156 = new LatLng(37.505877, 127.109814);
        LatLng pos157 = new LatLng(37.505877, 127.109814);
        LatLng pos158 = new LatLng(37.496960, 127.143252);
        LatLng pos159 = new LatLng(37.490047, 127.124178);
        LatLng pos160 = new LatLng(37.518860, 126.853721);
        LatLng pos161 = new LatLng(37.536406, 126.869271);
        LatLng pos162 = new LatLng(37.533611, 126.829100);
        LatLng pos163 = new LatLng(37.524528, 126.855800);
        LatLng pos164 = new LatLng(37.542740, 126.869157);
        LatLng pos165 = new LatLng(37.519797, 126.835004);
        LatLng pos166 = new LatLng(37.538649, 126.827181);
        LatLng pos167 = new LatLng(37.524679, 126.840163);
        LatLng pos168 = new LatLng(37.544702, 126.864425);
        LatLng pos169 = new LatLng(37.540115, 126.866968);
        LatLng pos170 = new LatLng(37.526358, 126.907409);
        LatLng pos171 = new LatLng(37.514625, 126.909339);
        LatLng pos172 = new LatLng(37.507084, 126.911734);
        LatLng pos173 = new LatLng(37.506344, 126.921476);
        LatLng pos174 = new LatLng(37.509427, 126.895906);
        LatLng pos175 = new LatLng(37.492774, 126.899443);
        LatLng pos176 = new LatLng(37.511100, 126.921438);
        LatLng pos177 = new LatLng(37.504350, 126.896042);
        LatLng pos178 = new LatLng(37.500504, 126.906368);
        LatLng pos179 = new LatLng(37.525942, 126.893995);
        LatLng pos180 = new LatLng(37.546896, 126.965281);
        LatLng pos181 = new LatLng(37.545948, 126.985448);
        LatLng pos182 = new LatLng(37.542474, 126.961852);
        LatLng pos183 = new LatLng(37.534785, 127.000060);
        LatLng pos184 = new LatLng(37.532588, 126.990044);
        LatLng pos185 = new LatLng(37.545732, 126.974897);
        LatLng pos186 = new LatLng(37.538550, 126.965428);
        LatLng pos187 = new LatLng(37.614136, 126.920792);
        LatLng pos188 = new LatLng(37.615169, 126.912686);
        LatLng pos189 = new LatLng(37.621542, 126.927609);
        LatLng pos190 = new LatLng(37.611703, 126.910368);
        LatLng pos191 = new LatLng(37.597956, 126.912179);
        LatLng pos192 = new LatLng(37.618257, 126.932946);
        LatLng pos193 = new LatLng(37.601110, 126.934808);
        LatLng pos194 = new LatLng(37.582701, 126.907587);
        LatLng pos195 = new LatLng(37.604388, 126.915098);
        LatLng pos196 = new LatLng(37.623640, 126.916701);
        LatLng pos197 = new LatLng(37.581811, 126.969278);
        LatLng pos198 = new LatLng(37.583408, 126.997768);
        LatLng pos199 = new LatLng(37.577782, 127.015637);
        LatLng pos200 = new LatLng(37.552189, 127.013326);
        LatLng pos201 = new LatLng(37.549062, 127.006333);
        LatLng pos202 = new LatLng(37.559994, 126.985806);
        LatLng pos203 = new LatLng(37.558164, 127.006729);
        LatLng pos204 = new LatLng(37.552345, 127.011232);
        LatLng pos205 = new LatLng(37.559955, 127.001272);
        LatLng pos206 = new LatLng(37.599811, 127.087156);
        LatLng pos207 = new LatLng(37.574673, 127.085602);
        LatLng pos208 = new LatLng(37.582921, 127.088109);
        LatLng pos209 = new LatLng(37.585772, 127.079512);
        LatLng pos210 = new LatLng(37.587304, 127.087490);
        mMap.addMarker(new MarkerOptions().position(pos1).title("1번").snippet("강남구\t영동대로65길 24\t대치2동 주민센터\n"));
        mMap.addMarker(new MarkerOptions().position(pos2).title("2번").snippet("강남구\t도곡로18길 57\t도곡1동 주민센터\n"));
        mMap.addMarker(new MarkerOptions().position(pos3).title("3번").snippet("강남구\t봉은사로 332\t강남시니어플라자\n"));
        mMap.addMarker(new MarkerOptions().position(pos4).title("4번").snippet("강남구\t학동로20길 25\t논현1동주민센터\n"));
        mMap.addMarker(new MarkerOptions().position(pos5).title("5번").snippet("강남구\t도곡로77길 23\t대치4동 주민센터\n"));
        mMap.addMarker(new MarkerOptions().position(pos6).title("6번").snippet("강남구\t남부순환로378길 34-9\t도곡2동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos7).title("7번").snippet("강남구\t양재대로55길 14\t일원1동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos8).title("8번").snippet("강동구\t강동대로55길 87\t중흥교회\n"));
        googleMap.addMarker(new MarkerOptions().position(pos9).title("9번").snippet("강동구\t구천면로 189\t2001아울렛천호점\n"));
        googleMap.addMarker(new MarkerOptions().position(pos10).title("10번").snippet("강동구\t천호대로187길 6\t길동자치회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos11).title("11번").snippet("강동구\t성내로 13\t성내1동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos12).title("12번").snippet("강동구\t상암로3길 28\t암사2동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos13).title("13번").snippet("강동구\t상암로 168\t강동구민회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos14).title("14번").snippet("강동구\t양재대로138길 41\t강동구 청소년회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos15).title("15번").snippet("강동구\t구천면로 395\t강동평생학습센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos16).title("16번").snippet("강동구\t고덕로20길 42\t강동구립암사도서관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos17).title("17번").snippet("강동구\t양재대로100길 13-4\t선린교회\n"));
        googleMap.addMarker(new MarkerOptions().position(pos18).title("18번").snippet("강북구\t삼양로92길 40\t강북노인종합복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos19).title("19번").snippet("강북구\t삼양로 561\t솔밭근린공원 개방화장실\n"));
        googleMap.addMarker(new MarkerOptions().position(pos20).title("20번").snippet("강북구\t삼각산로 85\t강북문화예술회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos21).title("21번").snippet("강북구\t한천로123길 26\t번동북부시장 북부마트\n"));
        googleMap.addMarker(new MarkerOptions().position(pos22).title("22번").snippet("강북구\t도봉로 338\t수유역1번출구\n"));
        googleMap.addMarker(new MarkerOptions().position(pos23).title("23번").snippet("강북구\t솔매로49길 14\t미아동 복합청사\n"));
        googleMap.addMarker(new MarkerOptions().position(pos24).title("24번").snippet("강북구\t도봉로89길 13\t강북구청 본관 입구\n"));
        googleMap.addMarker(new MarkerOptions().position(pos25).title("25번").snippet("강북구\t삼양로 299\t수유1동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos26).title("26번").snippet("강서구\t곰달래로25길 45\t화곡8동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos27).title("27번").snippet("강서구\t가로공원로 189\t가로공원공영주차장1번출구\n"));
        googleMap.addMarker(new MarkerOptions().position(pos28).title("28번").snippet("강서구\t우장산로 114\t화곡 6-1 공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos29).title("29번").snippet("강서구\t화곡로15길 40\t화곡 3-1 공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos30).title("30번").snippet("강서구\t곰달래로15길 28\t화곡 1-1 공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos31).title("31번").snippet("강서구\t강서로52길 89\t내발산동 문화센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos32).title("32번").snippet("강서구\t강서로5길 50\t곰달래복지문화센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos33).title("33번").snippet("강서구\t곰달래로57가길 26\t화곡4동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos34).title("34번").snippet("강서구\t까치산로4길 22\t볏골공원공원주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos35).title("35번").snippet("강서구\t송정로 45\t공항동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos36).title("36번").snippet("강서구\t강서로47길 54\t발산1동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos37).title("37번").snippet("강서구\t초록마을로14길 36\t구립 초록동경로당\n"));
        googleMap.addMarker(new MarkerOptions().position(pos38).title("38번").snippet("관악구\t신림로 282\t서원동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos39).title("39번").snippet("관악구\t신림로23길 17\t관악청소년회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos40).title("40번").snippet("관악구\t남부순환로246가길 20\t인헌동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos41).title("41번").snippet("관악구\t대학길 48\t대학동치안센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos42).title("42번").snippet("관악구\t남현1가길 29\t남현동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos43).title("43번").snippet("관악구\t쑥고개로 44\t청룡동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos44).title("44번").snippet("관악구\t조원로12길 25\t조원동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos45).title("45번").snippet("관악구\t조원로 151-1\t신사동자치회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos46).title("46번").snippet("관악구\t행운1길 43\t행운동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos47).title("47번").snippet("관악구\t관악로 145\t관악구청\n"));
        googleMap.addMarker(new MarkerOptions().position(pos48).title("48번").snippet("관악구\t대학10길 8-2\t신림여성회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos49).title("49번").snippet("광진구\t긴고랑로36길 56\t중곡감리교회\n"));
        googleMap.addMarker(new MarkerOptions().position(pos50).title("50번").snippet("광진구\t자양로 309\t구의2동 공동주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos51).title("51번").snippet("광진구\t자양번영로 35\t자양종합사회복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos52).title("52번").snippet("광진구\t능동로 433\t중곡문화체육센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos53).title("53번").snippet("광진구\t긴고랑로 110\t중곡종합건강센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos54).title("54번").snippet("광진구\t능동로17길 39\t화양동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos55).title("55번").snippet("광진구\t뚝섬로26길 58\t자양4동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos56).title("56번").snippet("광진구\t아차산로30길 36\t동부여성발전센터2\n"));
        googleMap.addMarker(new MarkerOptions().position(pos57).title("57번").snippet("광진구\t아차산로30길 36\t동부여성발전센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos58).title("58번").snippet("광진구\t긴고랑로12길 49\t중곡1동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos59).title("59번").snippet("광진구\t자양로 167\t광진경찰서\n"));
        googleMap.addMarker(new MarkerOptions().position(pos60).title("60번").snippet("구로구\t개봉로15길 58-2\t중앙경로당\n"));
        googleMap.addMarker(new MarkerOptions().position(pos61).title("61번").snippet("구로구\t구로동로26길 54\t구로구 시설관리공단\n"));
        googleMap.addMarker(new MarkerOptions().position(pos62).title("62번").snippet("구로구\t도림천로 352\t서울메트로대림별관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos63).title("63번").snippet("구로구\t부일로1길 62\t온수동 공동이용시설\n"));
        googleMap.addMarker(new MarkerOptions().position(pos64).title("64번").snippet("구로구\t오리로22길 5\t궁동종합사회복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos65).title("65번").snippet("구로구\t구로중앙로 174\t구로역1번출구 AK플라자입구\n"));
        googleMap.addMarker(new MarkerOptions().position(pos66).title("66번").snippet("구로구\t가마산로25길 21\t구로구민회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos67).title("67번").snippet("구로구\t고척로45길 39\t구로구민 체육센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos68).title("68번").snippet("구로구\t구로동로 141\t구로2동주민센터앞\n"));
        googleMap.addMarker(new MarkerOptions().position(pos69).title("69번").snippet("구로구\t경인로15길 22\t오류1동텃골공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos70).title("70번").snippet("금천구\t금하로 668\t금빛휘트니스센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos71).title("71번").snippet("금천구\t독산로50길 105\t시흥4치안센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos72).title("72번").snippet("금천구\t가산로 129\t가산동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos73).title("73번").snippet("금천구\t독산로36길 14\t시흥4동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos74).title("74번").snippet("금천구\t독산로72길 86-5\t금천호암노인복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos75).title("75번").snippet("금천구\t시흥대로18길 40\t시흥3동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos76).title("76번").snippet("금천구\t시흥대로123길 11\t독산1동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos77).title("77번").snippet("금천구\t시흥대로73길 70\t금천구청\n"));
        googleMap.addMarker(new MarkerOptions().position(pos78).title("78번").snippet("노원구\t상계로 118\t상계2동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos79).title("79번").snippet("노원구\t월계로 319\t월계문화정보도서관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos80).title("80번").snippet("노원구\t덕릉로 859\t상계3,4동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos81).title("81번").snippet("노원구\t상계로 190\t상계역 자전거대여소\n"));
        googleMap.addMarker(new MarkerOptions().position(pos82).title("82번").snippet("노원구\t노원로1나길 10\t공릉 청소년문화정보센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos83).title("83번").snippet("노원구\t동일로186길 3-24\t공릉1동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos84).title("84번").snippet("노원구\t석계로 93\t월계치안센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos85).title("85번").snippet("도봉구\t도봉로120길 16\t염광교회\n"));
        googleMap.addMarker(new MarkerOptions().position(pos86).title("86번").snippet("도봉구\t덕릉로62길 89\t창3동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos87).title("87번").snippet("도봉구\t도봉로 552\t도봉구민회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos88).title("88번").snippet("도봉구\t창1동 657-37\t창1동제1공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos89).title("89번").snippet("도봉구\t우이천로4길 24-5\t창동 도봉육아종합지원센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos90).title("90번").snippet("도봉구\t마들로 668\t도봉서원종합사회복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos91).title("91번").snippet("도봉구\t시루봉로17길 42\t방아골종합사회복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos92).title("92번").snippet("도봉구\t마들로11길 77\t창동역1번출구\n"));
        googleMap.addMarker(new MarkerOptions().position(pos93).title("93번").snippet("도봉구\t도봉로169나길 22\t도봉1동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos94).title("94번").snippet("도봉구\t덕릉로 247\t신창교회\n"));
        googleMap.addMarker(new MarkerOptions().position(pos95).title("95번").snippet("동대문구\t전농로27길 42\t나사렛 교회\n"));
        googleMap.addMarker(new MarkerOptions().position(pos96).title("96번").snippet("동대문구\t답십리로65길 124-5\t장안2동 공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos97).title("97번").snippet("동대문구\t천호대로 145\t동대문구청 종합민원실\n"));
        googleMap.addMarker(new MarkerOptions().position(pos98).title("98번").snippet("동대문구\t약령시로5길 22\t동대문종합사회복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos99).title("99번").snippet("동대문구\t회기로25길 31\t회기동공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos100).title("100번").snippet("동대문구\t서울시립대로4길 75\t답십리도서관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos101).title("101번").snippet("동대문구\t회기로10길 60\t정보화도서관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos102).title("102번").snippet("동대문구\t한천로18길 48\t장안종합사회복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos103).title("103번").snippet("동대문구\t제기로33길 25\t청소년수련원\n"));
        googleMap.addMarker(new MarkerOptions().position(pos104).title("104번").snippet("동작구\t노량진로 169\t순만빌딩\n"));
        googleMap.addMarker(new MarkerOptions().position(pos105).title("105번").snippet("동작구\t사당로8길 9\t사당문화회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos106).title("106번").snippet("동작구\t상도로53길 9\t상도1동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos107).title("107번").snippet("동작구\t국사봉8길 47\t예그리나주택\n"));
        googleMap.addMarker(new MarkerOptions().position(pos108).title("108번").snippet("동작구\t만양로 76\t강남교회 교육관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos109).title("109번").snippet("동작구\t상도로15바길 5\t동작 청소년문화의 집\n"));
        googleMap.addMarker(new MarkerOptions().position(pos110).title("110번").snippet("동작구\t장승배기로 161\t우리은행 동작구청지점2\n"));
        googleMap.addMarker(new MarkerOptions().position(pos111).title("111번").snippet("동작구\t장승배기로 161\t우리은행 동작구청지점\n"));
        googleMap.addMarker(new MarkerOptions().position(pos112).title("112번").snippet("동작구\t남부순환로 2081\t사당노인종합복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos113).title("113번").snippet("동작구\t장승배기로10길 42\t동작문화 복지센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos114).title("114번").snippet("동작구\t성대로2길 11\t상도3동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos115).title("115번").snippet("동작구\t신대방1나길 26\t해피유통\n"));
        googleMap.addMarker(new MarkerOptions().position(pos116).title("116번").snippet("마포구\t월드컵로31길 69\t초록북 카페\n"));
        googleMap.addMarker(new MarkerOptions().position(pos117).title("117번").snippet("마포구\t독막로 192\t신수동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos118).title("118번").snippet("마포구\t월드컵북로30길 22\t성산2동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos119).title("119번").snippet("마포구\t성미산로17길 79\t연남동희망원룸주택\n"));
        googleMap.addMarker(new MarkerOptions().position(pos120).title("120번").snippet("마포구\t성암로 197\t상암동 제1공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos121).title("121번").snippet("마포구\t대흥로20길 28\t마포아트센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos122).title("122번").snippet("마포구\t신촌로26길 10\t우리마포복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos123).title("123번").snippet("마포구\t동교로41길 36\t연남동 주민커뮤니티센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos124).title("124번").snippet("마포구\t도화길 37\t도화동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos125).title("125번").snippet("마포구\t숭문5길 8-6\t염리치안센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos126).title("126번").snippet("서대문구\t세검정로4길 32\t홍제3동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos127).title("127번").snippet("서대문구\t모래내로 334\t홍은2동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos128).title("128번").snippet("서대문구\t연희로 189\t연희동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos129).title("129번").snippet("서대문구\t홍은중앙로 85\t홍은1동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos130).title("130번").snippet("서대문구\t포방터길 28\t홍성교회\n"));
        googleMap.addMarker(new MarkerOptions().position(pos131).title("131번").snippet("서대문구\t가좌로 154\t서부제일교회 어린이도서관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos132).title("132번").snippet("서대문구\t봉원사2길 13\t봉원교회\n"));
        googleMap.addMarker(new MarkerOptions().position(pos133).title("133번").snippet("서대문구\t북아현로 24\t북아현동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos134).title("134번").snippet("서대문구\t북아현로22길 38\t충현동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos135).title("135번").snippet("서초구\t강남대로12길 44\t양재2동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos136).title("136번").snippet("서초구\t강남대로83길 55\t언구비 공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos137).title("137번").snippet("서초구\t방배로27길 13\t방배열린문화센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos138).title("138번").snippet("서초구\t청두곶길 36\t방배2동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos139).title("139번").snippet("서초구\t언남10길 48\t서초꿈나무라이온스 보금자리\n"));
        googleMap.addMarker(new MarkerOptions().position(pos140).title("140번").snippet("성동구\t왕십리로 89\t성동구민종합체육센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos141).title("141번").snippet("성동구\t고산자로10길 9\t성동구립도서관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos142).title("142번").snippet("성동구\t왕십리로21라길 11\t이든 아이빌\n"));
        googleMap.addMarker(new MarkerOptions().position(pos143).title("143번").snippet("성동구\t사근동길 37\t사근동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos144).title("144번").snippet("성북구\t북악산로31길 8\t제일빌딩(고대인근)\n"));
        googleMap.addMarker(new MarkerOptions().position(pos145).title("145번").snippet("성북구\t삼양로 20\t성북희망나눔봉사센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos146).title("146번").snippet("성북구\t보문로30가길 41-6\t안암교회\n"));
        googleMap.addMarker(new MarkerOptions().position(pos147).title("147번").snippet("성북구\t아리랑로 82\t아리랑 시네미디어센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos148).title("148번").snippet("성북구\t장위로 61\t성북여성교실\n"));
        googleMap.addMarker(new MarkerOptions().position(pos149).title("149번").snippet("성북구\t한천로95길 7\t성북청소년수련관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos150).title("150번").snippet("송파구\t새말로19길 6\t장지동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos151).title("151번").snippet("송파구\t거마로2길 19\t거여2동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos152).title("152번").snippet("송파구\t마천로 287\t마천2동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos153).title("153번").snippet("송파구\t백제고분로37길 16\t석촌동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos154).title("154번").snippet("송파구\t백제고분로32길 41\t송파노인종합복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos155).title("155번").snippet("송파구\t마천로 17\t여의도 순복음송파교회\n"));
        googleMap.addMarker(new MarkerOptions().position(pos156).title("156번").snippet("송파구\t백제고분로42길 5\t송파여성 문화회관2\n"));
        googleMap.addMarker(new MarkerOptions().position(pos157).title("157번").snippet("송파구\t백제고분로42길 5\t송파여성 문화회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos158).title("158번").snippet("송파구\t오금로53길 32\t거여1동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos159).title("159번").snippet("송파구\t동남로 116\t문정1동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos160).title("160번").snippet("양천구\t중앙로 250\t양천나눔누리센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos161).title("161번").snippet("양천구\t목동중앙로3길 21\t목동실버복지문화센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos162).title("162번").snippet("양천구\t남부순환로54길 5\t신월3동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos163).title("163번").snippet("양천구\t오목로34길 5\t신정4동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos164).title("164번").snippet("양천구\t목동중앙본로 73\t목동문화체육센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos165).title("165번").snippet("양천구\t지양로 47\t신월문화체육센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos166).title("166번").snippet("양천구\t화곡로4길 10\t신월5동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos167).title("167번").snippet("양천구\t오목로5길 34\t신월4동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos168).title("168번").snippet("양천구\t목동중앙남로16나길 55\t목3동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos169).title("169번").snippet("양천구\t목동중앙본로7가길 11\t목동보건지소\n"));
        googleMap.addMarker(new MarkerOptions().position(pos170).title("170번").snippet("영등포구\t버드나루로15길 10\t영등포평생학습관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos171).title("171번").snippet("영등포구\t신길로61길 17\t영등포본동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos172).title("172번").snippet("영등포구\t신길로40길 5\t신길4동1동1마을공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos173).title("173번").snippet("영등포구\t여의대방로43길 10\t신길7동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos174).title("174번").snippet("영등포구\t도영로7길 10\t도림동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos175).title("175번").snippet("영등포구\t대림로23가길 5\t다사랑어린이공원\n"));
        googleMap.addMarker(new MarkerOptions().position(pos176).title("176번").snippet("영등포구\t영등포로84길 24-5\t신길1동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos177).title("177번").snippet("영등포구\t도신로 27\t대림정보문화도서관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos178).title("178번").snippet("영등포구\t신풍로 1\t영등포구민 체육센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos179).title("179번").snippet("영등포구\t당산로29길 9\t그린케어센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos180).title("180번").snippet("용산구\t효창원로86길 33\t숙대 명재관 인근\n"));
        googleMap.addMarker(new MarkerOptions().position(pos181).title("181번").snippet("용산구\t신흥로 90\t용산치안센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos182).title("182번").snippet("용산구\t효창원로 161\t효창동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos183).title("183번").snippet("용산구\t이태원로 224-19\t한남동공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos184).title("184번").snippet("용산구\t녹사평대로 150\t용산구청후문\n"));
        googleMap.addMarker(new MarkerOptions().position(pos185).title("185번").snippet("용산구\t두텁바위로 25\t갈월종합사회복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos186).title("186번").snippet("용산구\t백범로 329\t용산꿈나무종합타운\n"));
        googleMap.addMarker(new MarkerOptions().position(pos187).title("187번").snippet("은평구\t연서로20길 24-6\t대조동 꿈나무어린이도서관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos188).title("188번").snippet("은평구\t갈현로 195\t연신내 지구대\n"));
        googleMap.addMarker(new MarkerOptions().position(pos189).title("189번").snippet("은평구\t연서로34길 11\t불광보건분소\n"));
        googleMap.addMarker(new MarkerOptions().position(pos190).title("190번").snippet("은평구\t갈현로17길 10\t구산동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos191).title("191번").snippet("은평구\t은평로 38\t신사종합사회복지관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos192).title("192번").snippet("은평구\t불광로 129\t불광1동 치안센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos193).title("193번").snippet("은평구\t은평로 245\t녹번 119안전센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos194).title("194번").snippet("은평구\t증산로5길 6\t증산 정보도서관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos195).title("195번").snippet("은평구\t연서로 59\t역촌동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos196).title("196번").snippet("은평구\t갈현로 301\t갈현1동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos197).title("197번").snippet("종로구\t자하문로19길 36\t청운효자동 자치회관\n"));
        googleMap.addMarker(new MarkerOptions().position(pos198).title("198번").snippet("종로구\t성균관로1길 6-3\t종로육아종합지원센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos199).title("199번").snippet("종로구\t지봉로 86\t숭인1동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos200).title("200번").snippet("중구\t동호로8다길 22\t약수동 공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos201).title("201번").snippet("중구\t동호로17길 270\t버티 공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos202).title("202번").snippet("중구\t퇴계로20길 3\t명동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos203).title("203번").snippet("중구\t동호로 241\t장충체육관 후문\n"));
        googleMap.addMarker(new MarkerOptions().position(pos204).title("204번").snippet("중구\t다산로8길 32\t약수교회 식당입구\n"));
        googleMap.addMarker(new MarkerOptions().position(pos205).title("205번").snippet("중구\t장충동2가 192-129\t장충공영주차장\n"));
        googleMap.addMarker(new MarkerOptions().position(pos206).title("206번").snippet("중랑구\t상봉중앙로1길 6\t상봉1동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos207).title("207번").snippet("중랑구\t면목로 246\t면목4동주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos208).title("208번").snippet("중랑구\t사가정로51길 48\t면목3,8동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos209).title("209번").snippet("중랑구\t동일로 619\t면목5동 주민센터\n"));
        googleMap.addMarker(new MarkerOptions().position(pos210).title("210번").snippet("중랑구\t면목로 397\t면목본동 주민센터\n"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoulCenter, 15));
        final EditText userinput = (EditText)findViewById(R.id.editText);
        ImageView button = (ImageView) findViewById(R.id.find_btn);
        final Geocoder geocoder = new Geocoder(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 주소입력후 지도2버튼 클릭시 해당 위도경도값의 지도화면으로 이동
                List<Address> list = null;

                String str = userinput.getText().toString();
                try {
                    list = geocoder.getFromLocationName
                            (str, // 지역 이름
                                    10); // 읽을 개수
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("test","입출력 오류 - 서버에서 주소변환시 에러발생");
                }

                if (list != null) {
                    if (list.size() == 0) {
                        Toast.makeText(Activity3.this,"해당되는 주소 정보는 없습니다",Toast.LENGTH_SHORT).show();
                    } else {
                        Address addr = list.get(0);
                        double lat = addr.getLatitude();
                        double lon = addr.getLongitude();
                        LatLng userplace = new LatLng(lat, lon);
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userplace, 15));
                        mMap.addMarker(new MarkerOptions().position(userplace).snippet(str).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    }
                }
            }
        });

        mMap = googleMap;

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(final Marker marker) {
                setClipBoardLink(getApplicationContext(), marker.getSnippet());
                return false;
            }
        });
    }

    public static void setClipBoardLink(Context context , String link) {
        ClipboardManager clipboardManager = (ClipboardManager)context.getSystemService(context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("주소", link);
        clipboardManager.setPrimaryClip(clipData);
    }

    public void onLastLocationButtonClicked(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_CODE_PERMISSIOINS);
            return;
        }
        mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                Log.d("a", "aaa");
                if(location != null) {
                    Log.d("a", "bbb");
                    LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.addMarker(new MarkerOptions()
                            .position(myLocation)
                            .title("현재 내 위치")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode) {
            case REQUEST_CODE_PERMISSIOINS:
                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager
                        .PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "현재 내 위치를 업데이트할 수 없습니다. 권한 허가가 필요합니다.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this, "버튼을 누르면 현재 내 위치를 업데이트 할 수 있습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
