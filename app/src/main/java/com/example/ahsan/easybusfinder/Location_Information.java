package com.example.ahsan.easybusfinder;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.Manifest;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class Location_Information extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener,LocationListener {

    private GoogleMap mMap;
    private TextView busnameTextview;
    String busname;

    private GoogleApiClient getGoogleApiClient;
    private LocationRequest locationRequest;
    private Location lastLocatin;
    private static final int Request_User_Location_Code=99;
    private Marker currentUserLocatinMarker;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_information);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        busnameTextview=findViewById(R.id.bus_no_in_map);

        //Receive data
        Intent intent=getIntent();
         busname=intent.getExtras().getString("Bus no");
        busnameTextview.setText(busname);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            checkUserLoactionPermission();
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(busname.equals("01 No bus"))
        {
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
            LatLng newmarket = new LatLng(22.333919, 91.832689);
            mMap.addMarker(new MarkerOptions().position(newmarket).title("New Market Bus Stand"));
            LatLng Kotwali = new LatLng(22.333264, 91.836605);
            mMap.addMarker(new MarkerOptions().position(Kotwali).title("Kotwali Bus Stop"));
            LatLng Laldighi = new LatLng(22.338901, 91.838021);
            mMap.addMarker(new MarkerOptions().position(Laldighi).title("Laldighir Par Bus Stop"));
            LatLng Anderkilla  = new LatLng(22.342096, 91.836658);
            mMap.addMarker(new MarkerOptions().position(Anderkilla ).title("Anderkilla Bus Stop"));
            LatLng Nabab  = new LatLng(22.354321, 91.839029);
            mMap.addMarker(new MarkerOptions().position(Nabab ).title("Nabab Siraj Ud Daula Road"));
            LatLng College  = new LatLng(22.354312, 91.838879);
            mMap.addMarker(new MarkerOptions().position(College).title("College Bypass"));
            LatLng Kapasgola = new LatLng(22.360850, 91.841400);
            mMap.addMarker(new MarkerOptions().position(Kapasgola).title("Kapasgola Road"));
            LatLng Arkan = new LatLng(22.362800, 91.842854);
            mMap.addMarker(new MarkerOptions().position(Arkan).title("Arkan Road"));
            LatLng Bahaddarhat = new LatLng(22.368523, 91.843761);
            mMap.addMarker(new MarkerOptions().position(Bahaddarhat).title("Bahaddarhat Bus Stop"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newmarket, 18));
            // mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }

            mMap.addPolyline(new PolylineOptions().add(newmarket,new LatLng(22.333462, 91.834523),new LatLng(22.333383, 91.836015),new LatLng(22.333750, 91.836583),new LatLng(22.337095, 91.837292),
                    new LatLng(22.338424, 91.837452),new LatLng(22.338990, 91.837903),new LatLng(22.340558, 91.837570),new LatLng(22.340985, 91.837420),
                    new LatLng(22.341054, 91.837399),new LatLng(22.341729, 91.836776),new LatLng(22.342285, 91.836851),new LatLng(22.344002, 91.837817),
                    new LatLng(22.345659, 91.837774),new LatLng(22.346842, 91.838164),new LatLng(22.351434, 91.838621),new LatLng(22.352644, 91.838578),
                    new LatLng(22.352763, 91.838600),new LatLng(22.353270, 91.838739),new LatLng(22.355919, 91.839641),new LatLng(22.357695, 91.839780),
                    new LatLng(22.358370, 91.839351),new LatLng(22.358958, 91.840048),new LatLng(22.359692, 91.840531),new LatLng(22.359920, 91.841304),
                    new LatLng(22.360982, 91.841475),new LatLng(22.363085, 91.842945),new LatLng(22.366082, 91.842816),new LatLng(22.366092, 91.842795),
                    new LatLng(22.367421, 91.842956),new LatLng(22.368116, 91.843428),new LatLng(22.368523, 91.843761)).width(5).color(Color.RED));

        }
        if(busname.equals("02 No bus")) {
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
            LatLng newmarket = new LatLng(22.333929, 91.832657);
            mMap.addMarker(new MarkerOptions().position(newmarket).title("New Market Bus Stand"));
            LatLng Kotwali = new LatLng(22.333403, 91.836133);
            mMap.addMarker(new MarkerOptions().position(Kotwali).title("Kotwali Bus Stop"));
            LatLng Laldighi = new LatLng(22.338950, 91.837839);
            mMap.addMarker(new MarkerOptions().position(Laldighi).title("Laldighir Par Bus Stop"));
            LatLng Anderkilla  = new LatLng(22.342195, 91.836744);
            mMap.addMarker(new MarkerOptions().position(Anderkilla ).title("Anderkilla Bus Stop"));
            LatLng Cheragi = new LatLng(22.343763, 91.833676);
            mMap.addMarker(new MarkerOptions().position(Cheragi).title("Cheragi Pahar"));
            LatLng JamalKhan= new LatLng(22.348040, 91.833890);
            mMap.addMarker(new MarkerOptions().position(JamalKhan).title("Jamal Khan Road"));
            LatLng College = new LatLng(22.353398, 91.836723);
            mMap.addMarker(new MarkerOptions().position(College).title("College Road"));
            LatLng Chawkbazar = new LatLng(22.357209, 91.837302);
            mMap.addMarker(new MarkerOptions().position(Chawkbazar).title("Chawkbazar Bus Stop"));
            LatLng Fazlul = new LatLng(22.359878, 91.832646);
            mMap.addMarker(new MarkerOptions().position(Fazlul).title("K.B. Fazlul Kader Road "));
            LatLng Probortok = new LatLng(22.360890, 91.828601);
            mMap.addMarker(new MarkerOptions().position(Probortok).title("Probortok"));
            LatLng twoNo = new LatLng(22.366476, 91.822936);
            mMap.addMarker(new MarkerOptions().position(twoNo).title("2 NO. Gate Bus Stop"));
            LatLng Muradpur = new LatLng(22.369085, 91.833075);
            mMap.addMarker(new MarkerOptions().position(Muradpur).title("Muradpur Bus Stop"));
            LatLng Bahaddarhat = new LatLng(22.368465, 91.843868);
            mMap.addMarker(new MarkerOptions().position(Bahaddarhat).title("Bahaddarhat Bus Stop"));
            LatLng Hazera = new LatLng(22.378345, 91.853922);
            mMap.addMarker(new MarkerOptions().position(Hazera).title("Hazera - Taju Degree College"));
            LatLng CNB = new LatLng(22.387383, 91.860703);
            mMap.addMarker(new MarkerOptions().position(CNB).title("CNB Bus Stop"));
            LatLng Kaptai = new LatLng(22.394476, 91.868586);
            mMap.addMarker(new MarkerOptions().position(Kaptai).title("Kaptai Rastar Matha Bus Stop"));


            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newmarket, 18));
            // mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }

            mMap.addPolyline(new PolylineOptions().add(newmarket,new LatLng(22.333462, 91.834534),new LatLng(22.333403, 91.836133),new LatLng(22.337085, 91.837302),
                    new LatLng(22.338444, 91.837517),new LatLng(22.338940, 91.837860),new LatLng(22.340895, 91.837485),new LatLng(22.341739, 91.836776),
                    new LatLng(22.342195, 91.836744),new LatLng(22.342632, 91.836347),new LatLng(22.343019, 91.835446),new LatLng(22.343475, 91.834523),
                    new LatLng(22.343763, 91.833676),new LatLng(22.345272, 91.834083),new LatLng(22.346720, 91.834255),new LatLng(22.348040, 91.833890),
                    new LatLng(22.349062, 91.834491),new LatLng(22.350074, 91.834834),new LatLng(22.350541, 91.835425),new LatLng(22.350888, 91.836433),
                    new LatLng(22.353398, 91.836723),new LatLng(22.355184, 91.837367),new LatLng(22.356276, 91.837549),new LatLng(22.358052, 91.837420),
                    new LatLng(22.359610, 91.836401),new LatLng(22.359521, 91.834008),new LatLng(22.359828, 91.832657),new LatLng(22.360612, 91.832142),
                    new LatLng(22.360830, 91.828773),new LatLng(22.361197, 91.827582),new LatLng(22.363112, 91.826756),new LatLng(22.365027, 91.824363),
                    new LatLng(22.366406, 91.823001),new LatLng(22.367339, 91.824513),new LatLng(22.368182, 91.828086),new LatLng(22.368778, 91.830082),
                    new LatLng(22.368956, 91.830929),new LatLng(22.369085, 91.833075),new LatLng(22.368411, 91.838085),new LatLng(22.367974, 91.841722),
                    new LatLng(22.368394, 91.843644),new LatLng(22.374327, 91.849544),new LatLng(22.378792, 91.854029),new LatLng(22.380836, 91.854737),
                    new LatLng(22.382621, 91.856282),new LatLng(22.383534, 91.857248),new LatLng(22.385835, 91.858986),new LatLng(22.387383, 91.860703),
                    new LatLng(22.389848, 91.863100),new LatLng(22.393561, 91.865094),new LatLng(22.394476, 91.868586)).width(15).color(Color.RED));

        }
        if(busname.equals("03 No bus")) {
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
            LatLng newmarket = new LatLng(22.334127, 91.832549);
            mMap.addMarker(new MarkerOptions().position(newmarket).title("New Market"));
            LatLng Amtala = new LatLng(22.336420, 91.832217);
            mMap.addMarker(new MarkerOptions().position(Amtala).title("Amtala"));
            LatLng Jubilee = new LatLng(22.339532, 91.828340);
            mMap.addMarker(new MarkerOptions().position(Jubilee).title("Jubilee Road"));
            LatLng KazirDewri = new LatLng(22.347602, 91.825620);
            mMap.addMarker(new MarkerOptions().position(KazirDewri).title("Kazir Dewri Circle"));
            LatLng Almas  = new LatLng(22.349696, 91.824998);
            mMap.addMarker(new MarkerOptions().position(Almas).title("Almas"));
            LatLng WASA = new LatLng(22.351124, 91.822058);
            mMap.addMarker(new MarkerOptions().position(WASA).title("WASA"));
            LatLng GEC = new LatLng(22.359059, 91.821514);
            mMap.addMarker(new MarkerOptions().position(GEC).title("GEC Circle"));
            LatLng twoNo = new LatLng(22.366481, 91.823052);
            mMap.addMarker(new MarkerOptions().position(twoNo).title("2 No. Gate"));
            LatLng Muradpur = new LatLng(22.368993, 91.833071);
            mMap.addMarker(new MarkerOptions().position(Muradpur).title("Muradpur"));
            LatLng Hamjarbag = new LatLng(22.376515, 91.831721);
            mMap.addMarker(new MarkerOptions().position(Hamjarbag).title("Hamjarbag"));
            LatLng Hashem = new LatLng(22.382084, 91.829068);
            mMap.addMarker(new MarkerOptions().position(Hashem).title("Hashem Bazar"));
            LatLng Oxyzen = new LatLng(22.393494, 91.821507);
            mMap.addMarker(new MarkerOptions().position(Oxyzen).title("Oxyzen"));
            LatLng Aman = new LatLng(22.421582, 91.820076);
            mMap.addMarker(new MarkerOptions().position(Aman).title("Aman Bazaar"));
            LatLng BaraDighi = new LatLng(22.431452, 91.820026);
            mMap.addMarker(new MarkerOptions().position(BaraDighi).title("Bara Dighir Par"));
            LatLng Chowdhuryhat = new LatLng(22.442601, 91.820130);
            mMap.addMarker(new MarkerOptions().position(Chowdhuryhat).title("Chowdhuryhat"));
            LatLng Fatehabad = new LatLng(22.448205, 91.818343);
            mMap.addMarker(new MarkerOptions().position(Fatehabad).title("Fatehabad"));
            LatLng NandirHat = new LatLng(22.461209, 91.816505);
            mMap.addMarker(new MarkerOptions().position(NandirHat).title("Nandir Hat"));
            LatLng cu = new LatLng(22.475794, 91.813767);
            mMap.addMarker(new MarkerOptions().position(cu).title("Chittagong University"));
            LatLng hathazari= new LatLng(22.498449, 91.806992);
            mMap.addMarker(new MarkerOptions().position(hathazari).title("Hathazari"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newmarket, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
               return;
            }
            mMap.addPolyline(new PolylineOptions().add(newmarket,new LatLng(22.335339, 91.832452),new LatLng(22.336460, 91.832205),new LatLng(22.337383, 91.831057),
                    new LatLng(22.337810, 91.830564),new LatLng(22.338316, 91.830102),new LatLng(22.338713, 91.829094),new LatLng(22.339958, 91.828064),
                    new LatLng(22.341019, 91.827721),new LatLng(22.345808, 91.826273),new LatLng(22.347049, 91.825926),
                    new LatLng(22.347684, 91.825593),new LatLng(22.348290, 91.825287),new LatLng(22.349108, 91.825024),new LatLng(22.349728, 91.824998),
                    new LatLng(22.350453, 91.823587),new LatLng(22.351031, 91.822487),new LatLng(22.351123, 91.822079),new LatLng(22.351915, 91.822076),
                    new LatLng(22.353612, 91.821990),new LatLng(22.354901, 91.821974),new LatLng(22.356872, 91.821620),new LatLng(22.358226, 91.821395),
                    new LatLng(22.358732, 91.821438),new LatLng(22.359700, 91.821786),new LatLng(22.360439, 91.821760),new LatLng(22.361049, 91.821609),
                    new LatLng(22.362240, 91.821245),new LatLng(22.362999, 91.821046),new LatLng(22.364080, 91.821127),new LatLng(22.365067, 91.821615),
                    new LatLng(22.365747, 91.822226),new LatLng(22.366466, 91.823074),new LatLng(22.367057, 91.823932),new LatLng(22.367429, 91.824946),
                    new LatLng(22.367751, 91.826529),new LatLng(22.368267, 91.828583),new LatLng(22.368843, 91.830477),new LatLng(22.369041, 91.831539),
                    new LatLng(22.369086, 91.833116),new LatLng(22.369969, 91.833218),new LatLng(22.370767, 91.833411),new LatLng(22.371730, 91.833572),
                    new LatLng(22.372370, 91.833631),new LatLng(22.373183, 91.833288),new LatLng(22.374071, 91.833019),new LatLng(22.374890, 91.832601),
                    new LatLng(22.375897, 91.832048),new LatLng(22.376601, 91.831689),new LatLng(22.377437, 91.831448),new LatLng(22.378148, 91.831241),
                    new LatLng(22.379170, 91.830850),new LatLng(22.380261, 91.830228),new LatLng(22.381506, 91.829664),new LatLng(22.382361, 91.828688),
                    new LatLng(22.383199, 91.827727),new LatLng(22.384226, 91.826606),new LatLng(22.385451, 91.825759),new LatLng(22.386723, 91.825101),
                    new LatLng(22.389002, 91.824453),new LatLng(22.390443, 91.824024),new LatLng(22.390936, 91.823694),new LatLng(22.392659, 91.822821),
                    new LatLng(22.393509, 91.821531),new LatLng(22.394590, 91.820892),new LatLng(22.395805, 91.820430),new LatLng(22.397174, 91.820044),
                    new LatLng(22.398672, 91.819814),new LatLng(22.399664, 91.819626),new LatLng(22.400661, 91.819245),new LatLng(22.401330, 91.819073),
                    new LatLng(22.403686, 91.819036),new LatLng(22.405670, 91.818708),new LatLng(22.407376, 91.818301),new LatLng(22.408303, 91.817893),
                    new LatLng(22.409017, 91.817786),new LatLng(22.409801, 91.817898),new LatLng(22.411145, 91.818317),new LatLng(22.412425, 91.818590),
                    new LatLng(22.414220, 91.819121),new LatLng(22.415812, 91.819161),new LatLng(22.417446, 91.819221),new LatLng(22.418904, 91.819543),
                    new LatLng(22.419807, 91.819790),new LatLng(22.420521, 91.819913),new LatLng(22.421071, 91.820021),new LatLng(22.422395, 91.820037),
                    new LatLng(22.423055, 91.819833),new LatLng(22.424270, 91.819790),new LatLng(22.425390, 91.819527),new LatLng(22.426100, 91.819399),
                    new LatLng(22.427101, 91.819441),new LatLng(22.430190, 91.819909),new LatLng(22.431452, 91.820026),new LatLng(22.433674, 91.820296),
                    new LatLng(22.436365, 91.820201),new LatLng(22.439315, 91.820696),new LatLng(22.440945, 91.820095),new LatLng(22.442338, 91.819983),
                    new LatLng(22.443012, 91.819591),new LatLng(22.444683, 91.818932),new LatLng(22.445916, 91.818613),new LatLng(22.448109, 91.818351),
                    new LatLng(22.449487, 91.817986),new LatLng(22.450702, 91.817761),new LatLng(22.452135, 91.817396),new LatLng(22.453635, 91.817262),
                    new LatLng(22.455908, 91.817069),new LatLng(22.458012, 91.816754),new LatLng(22.459700, 91.816503),new LatLng(22.460897, 91.816462),
                    new LatLng(22.462632, 91.816568),new LatLng(22.464164, 91.816529),new LatLng(22.465515, 91.816459),new LatLng(22.466710, 91.816303),
                    new LatLng(22.467930, 91.816250),new LatLng(22.469565, 91.815965),new LatLng(22.470131, 91.815493),new LatLng(22.470790, 91.815193),
                    new LatLng(22.471077, 91.814941),new LatLng(22.471494, 91.815075),new LatLng(22.473189, 91.814715),new LatLng(22.475236, 91.814227),
                    new LatLng(22.475838, 91.813957),new LatLng(22.478420, 91.813350),new LatLng(22.479015, 91.812760),new LatLng(22.479496, 91.811816),
                    new LatLng(22.480903, 91.811529),new LatLng(22.482093, 91.811464),new LatLng(22.482647, 91.811510),new LatLng(22.484035, 91.811070),
                    new LatLng(22.484734, 91.810764),new LatLng(22.485966, 91.810004),new LatLng(22.486532, 91.809591),new LatLng(22.487131, 91.808985),
                    new LatLng(22.487612, 91.808411),new LatLng(22.488222, 91.808041),new LatLng(22.489306, 91.807936),new LatLng(22.490982, 91.808030),
                    new LatLng(22.492464, 91.808057),new LatLng(22.493609, 91.807762),new LatLng(22.495587, 91.807536),new LatLng(22.496360, 91.807483),
                    new LatLng(22.496662, 91.807365),new LatLng(22.497923, 91.807145),hathazari).width(15).color(Color.RED));

        }
        if(busname.equals("04 No bus")) {
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
            LatLng newmarket = new LatLng(22.333909, 91.832399);
            mMap.addMarker(new MarkerOptions().position(newmarket).title("New Market"));
            LatLng BRTC = new LatLng(22.336311, 91.824374);
            mMap.addMarker(new MarkerOptions().position(BRTC).title("BRTC"));
            LatLng Kadamtoli = new LatLng(22.336856, 91.822271);
            mMap.addMarker(new MarkerOptions().position(Kadamtoli).title("Kadamtoli"));
            LatLng Tigerpass  = new LatLng(22.342106, 91.815898);
            mMap.addMarker(new MarkerOptions().position(Tigerpass).title("Tigerpass"));
            LatLng Ispahani = new LatLng(22.347363, 91.819162);
            mMap.addMarker(new MarkerOptions().position(Ispahani).title("Ispahani Circle"));
            LatLng LalKhan = new LatLng(22.347522, 91.819345);
            mMap.addMarker(new MarkerOptions().position(LalKhan).title("Lal Khan Bazar"));
            LatLng Wasa = new LatLng(22.351858, 91.821977);
            mMap.addMarker(new MarkerOptions().position(Wasa).title("Wasa"));
            LatLng Garibulla = new LatLng(22.356254, 91.821666);
            mMap.addMarker(new MarkerOptions().position(Garibulla).title("Garibulla Shah A/C "));
            LatLng GEC = new LatLng(22.359306, 91.819761);
            mMap.addMarker(new MarkerOptions().position(GEC).title("GEC"));
            LatLng Zakir = new LatLng(22.361638, 91.812761);
            mMap.addMarker(new MarkerOptions().position(Zakir).title("Zakir Hossain Road"));
            LatLng HolyCresent = new LatLng(22.362042, 91.809035);
            mMap.addMarker(new MarkerOptions().position(HolyCresent).title("Holy Cresent"));
            LatLng Wireless = new LatLng(22.361741, 91.803511);
            mMap.addMarker(new MarkerOptions().position(Wireless).title("Wireless"));
            LatLng FoysLake = new LatLng(22.361945, 91.798076);
            mMap.addMarker(new MarkerOptions().position(FoysLake).title("Foy's Lake"));
            LatLng AkbarShah = new LatLng(22.360494, 91.792250);
            mMap.addMarker(new MarkerOptions().position(AkbarShah).title("Akbar Shah"));
            LatLng IspahaniCrossing = new LatLng(22.363036, 91.785567);
            mMap.addMarker(new MarkerOptions().position(IspahaniCrossing).title("Ispahani Crossing"));
            LatLng AKKhan = new LatLng(22.334034, 91.832280);
            mMap.addMarker(new MarkerOptions().position(AKKhan).title("AK Khan"));
            LatLng Kaibalyadham = new LatLng(22.363826, 91.781532);
            mMap.addMarker(new MarkerOptions().position(Kaibalyadham).title("Kaibalyadham"));
            LatLng CDA = new LatLng(22.371723, 91.775284);
            mMap.addMarker(new MarkerOptions().position(CDA).title("CDA"));
            LatLng CityGate = new LatLng(22.334034, 91.832280);
            mMap.addMarker(new MarkerOptions().position(CityGate).title("City Gate"));
            LatLng KalirHat = new LatLng(22.375760, 91.770937);
            mMap.addMarker(new MarkerOptions().position(KalirHat).title("Kalir Hat"));
            LatLng PakkarMatha = new LatLng(22.380461, 91.765962);
            mMap.addMarker(new MarkerOptions().position(PakkarMatha).title("Pakkar Matha"));
            LatLng Fakirhat = new LatLng(22.386261, 91.761767);
            mMap.addMarker(new MarkerOptions().position(Fakirhat).title("Fakirhat"));
            LatLng Faujdarhat = new LatLng(22.402625, 91.756581);
            mMap.addMarker(new MarkerOptions().position(Faujdarhat).title("Faujdarhat"));
            LatLng Bhatiari = new LatLng(22.424535, 91.745920);
            mMap.addMarker(new MarkerOptions().position(Bhatiari).title("Bhatiari"));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newmarket, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
               return;
            }

            mMap.addPolyline(new PolylineOptions().add(newmarket,new LatLng(22.334395, 91.830704),new LatLng(22.335239, 91.829921),new LatLng(22.335556, 91.828977),
                    new LatLng(22.335576, 91.827979),new LatLng(22.335527, 91.827013),new LatLng(22.336043, 91.824814),new LatLng(22.336618, 91.823784),
                    new LatLng(22.336926, 91.822132),new LatLng(22.337263, 91.820372),new LatLng(22.338405, 91.820297),new LatLng(22.339623, 91.819179),
                    new LatLng(22.340736, 91.817737),new LatLng(22.342066, 91.815859),new LatLng(22.344229, 91.817331),new LatLng(22.345628, 91.818007),
                    new LatLng(22.346749, 91.818693),new LatLng(22.347533, 91.819391),new LatLng(22.348446, 91.820292),new LatLng(22.349200, 91.821129),
                    new LatLng(22.350987, 91.822019),new LatLng(22.352108, 91.822014),new LatLng(22.354301, 91.821966),new LatLng(22.355005, 91.821949),
                    new LatLng(22.356126, 91.821687),new LatLng(22.356811, 91.820930),new LatLng(22.357307, 91.820426),new LatLng(22.357719, 91.820185),
                    new LatLng(22.358414, 91.819916),new LatLng(22.358885, 91.819761),new LatLng(22.359336, 91.819755),new LatLng(22.359614, 91.819310),
                    new LatLng(22.359813, 91.818666),new LatLng(22.360522, 91.817733),new LatLng(22.361251, 91.817170),new LatLng(22.361832, 91.816617),
                    new LatLng(22.361840, 91.816299),new LatLng(22.361493, 91.814035),new LatLng(22.361533, 91.813043),new LatLng(22.361786, 91.812051),
                    new LatLng(22.361895, 91.811123),new LatLng(22.362034, 91.810248),new LatLng(22.362068, 91.808907),new LatLng(22.361885, 91.807652),
                    new LatLng(22.361756, 91.806085),new LatLng(22.361701, 91.804251),new LatLng(22.361929, 91.802438),new LatLng(22.361954, 91.801746),
                    new LatLng(22.361929, 91.800447),new LatLng(22.362058, 91.798468),new LatLng(22.361929, 91.797868),new LatLng(22.361855, 91.797342),
                    new LatLng(22.361498, 91.796795),new LatLng(22.361369, 91.796280),new LatLng(22.361170, 91.795910),new LatLng(22.360699, 91.795314),
                    new LatLng(22.360590, 91.794998),new LatLng(22.360590, 91.794526),new LatLng(22.360763, 91.794193),new LatLng(22.360570, 91.793233),
                    new LatLng(22.360466, 91.792305),new LatLng(22.360490, 91.791656),new LatLng(22.361782, 91.789567),new LatLng(22.361752, 91.789278),
                    new LatLng(22.361132, 91.788623),new LatLng(22.360794, 91.787491),new LatLng(22.362935, 91.785691),new LatLng(22.363137, 91.784746),
                    new LatLng(22.362892, 91.783955),new LatLng(22.362824, 91.781934),new LatLng(22.364594, 91.781211),new LatLng(22.366614, 91.779623),
                    new LatLng(22.368035, 91.778548),new LatLng(22.368987, 91.777878),new LatLng(22.369821, 91.776784),new LatLng(22.371011, 91.775805),
                    new LatLng(22.372108, 91.774988),new LatLng(22.373789, 91.773420),new LatLng(22.375803, 91.770904),new LatLng(22.377909, 91.769155),
                    new LatLng(22.379353, 91.767391),new LatLng(22.380206, 91.766217),new LatLng(22.381469, 91.765166),new LatLng(22.382830, 91.764237),
                    new LatLng(22.384455, 91.762945),new LatLng(22.386167, 91.761803),new LatLng(22.389481, 91.760297),new LatLng(22.391177, 91.759550),
                    new LatLng(22.393483, 91.758869),new LatLng(22.395891, 91.758386),new LatLng(22.397310, 91.758021),new LatLng(22.399661, 91.757383),
                    new LatLng(22.401491, 91.756857),new LatLng(22.402835, 91.756508),new LatLng(22.405026, 91.756033),new LatLng(22.407242, 91.755448),
                    new LatLng(22.408890, 91.755040),new LatLng(22.410843, 91.754611),new LatLng(22.412727, 91.754128),new LatLng(22.414116, 91.753490),
                    new LatLng(22.415143, 91.752862),new LatLng(22.416824, 91.751569),new LatLng(22.418510, 91.750421),new LatLng(22.419700, 91.749783),
                    new LatLng(22.421218, 91.748973),new LatLng(22.422239, 91.748227),new LatLng(22.423176, 91.747326),new LatLng(22.423876, 91.746591),
                    Bhatiari).width(15).color(Color.RED));
        }
        if(busname.equals("05 No bus")) {
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
            LatLng Laldighi = new LatLng(22.338965, 91.837905);
            mMap.addMarker(new MarkerOptions().position(Laldighi).title("Laldighir Par"));
            LatLng Kotwali = new LatLng(22.333726, 91.836488);
            mMap.addMarker(new MarkerOptions().position(Kotwali).title("Kotwali"));
            LatLng newmarket = new LatLng(22.333865, 91.832626);
            mMap.addMarker(new MarkerOptions().position(newmarket).title("New Market"));
            LatLng Ice  = new LatLng(22.332604, 91.830419);
            mMap.addMarker(new MarkerOptions().position(Ice).title("Ice Factory Road"));
            LatLng Majhirghat  = new LatLng(22.332156, 91.822685);
            mMap.addMarker(new MarkerOptions().position(Majhirghat).title("Majhirghat Road"));
            LatLng TrunkRoad = new LatLng(22.328963, 91.821804);
            mMap.addMarker(new MarkerOptions().position(TrunkRoad).title("Dhaka Trunk Road"));
            LatLng Barik = new LatLng(22.319376, 91.812079);
            mMap.addMarker(new MarkerOptions().position(Barik).title("Barik Building"));
            LatLng Sagorika= new LatLng(22.315907, 91.807461);
            mMap.addMarker(new MarkerOptions().position(Sagorika).title("Sagorika"));
            LatLng Fakir = new LatLng(22.314917, 91.805195);
            mMap.addMarker(new MarkerOptions().position(Fakir).title("Fakir Hat"));
            LatLng Customs = new LatLng(22.311848, 91.799183);
            mMap.addMarker(new MarkerOptions().position(Customs).title("Customs"));
            LatLng Saltgola= new LatLng(22.305418, 91.793330);
            mMap.addMarker(new MarkerOptions().position(Saltgola).title("Saltgola"));
            LatLng Crossing = new LatLng(22.302484, 91.791586);
            mMap.addMarker(new MarkerOptions().position(Crossing).title("Salt Gola Crossing"));
            LatLng Seamens = new LatLng(22.300859, 91.788725);
            mMap.addMarker(new MarkerOptions().position(Seamens).title("Seamens Hostel"));
            LatLng mm2 = new LatLng(22.300059, 91.786595);
            mMap.addMarker(new MarkerOptions().position(mm2).title("Mailer Matha 2"));
            LatLng mm1 = new LatLng(22.299220, 91.785528);
            mMap.addMarker(new MarkerOptions().position(mm1).title("Mailer Matha 1"));
            LatLng CEPZ = new LatLng(22.293329, 91.782133);
            mMap.addMarker(new MarkerOptions().position(CEPZ).title("CEPZ"));
            LatLng Bandartila = new LatLng(22.286772, 91.784124);
            mMap.addMarker(new MarkerOptions().position(Bandartila).title("Bandartila"));
            LatLng Hospital = new LatLng(22.282923, 91.784618);
            mMap.addMarker(new MarkerOptions().position(Hospital).title("Hospital Gate"));
            LatLng Cement = new LatLng(22.278694, 91.785469);
            mMap.addMarker(new MarkerOptions().position(Cement).title("Cement Crossing"));
            LatLng Airport = new LatLng(22.240402, 91.818054);
            mMap.addMarker(new MarkerOptions().position(Airport).title("Airport Road"));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newmarket, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            mMap.addPolyline(new PolylineOptions().add(Laldighi,new LatLng(22.338112, 91.838280),new LatLng(22.337417, 91.838259),new LatLng(22.337070, 91.837325),
                    new LatLng(22.333835, 91.836574),new LatLng(22.333398, 91.835995),new LatLng(22.333458, 91.834321),new LatLng(22.333944, 91.832562),
                    new LatLng(22.333152, 91.832164),new LatLng(22.332547, 91.831977),new LatLng(22.332641, 91.831365),new LatLng(22.332542, 91.830721),
                    new LatLng(22.333267, 91.826934),new LatLng(22.333956, 91.823458),new LatLng(22.332108, 91.823461),new LatLng(22.332210, 91.821937),
                    new LatLng(22.326976, 91.821780),new LatLng(22.325837, 91.821249),new LatLng(22.324924, 91.820208),new LatLng(22.324021, 91.819210),
                    new LatLng(22.319456, 91.812097),new LatLng(22.318334, 91.810595),new LatLng(22.317183, 91.809715),new LatLng(22.314880, 91.805059),
                    new LatLng(22.314483, 91.803600),new LatLng(22.312002, 91.799330),new LatLng(22.307337, 91.794588),new LatLng(22.302473, 91.791626),
                    new LatLng(22.300766, 91.788472),new LatLng(22.300567, 91.787421),new LatLng(22.299197, 91.785425),new LatLng(22.293400, 91.782142),
                    new LatLng(22.286709, 91.784095),new LatLng(22.284168, 91.784588),new LatLng(22.282123, 91.784567),new LatLng(22.278708, 91.785490),
                    new LatLng(22.281070, 91.795833),new LatLng(22.279434, 91.797044),new LatLng(22.276336, 91.800456),new LatLng(22.273258, 91.804855),
                    new LatLng(22.271292, 91.808932),new LatLng(22.269326, 91.814704),new LatLng(22.267341, 91.815927),new LatLng(22.266527, 91.819983),
                    new LatLng(22.267758, 91.822064),new LatLng(22.266745, 91.826356),new LatLng(22.265931, 91.827471),new LatLng(22.264700, 91.828201),
                    new LatLng(22.257134, 91.828780),new LatLng(22.255128, 91.828416),new LatLng(22.252645, 91.827493),new LatLng(22.243411, 91.820969),
                    Airport).width(15).color(Color.RED));
        }
        if(busname.equals("06 No bus")) {
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
            LatLng Laldighi = new LatLng(22.338973, 91.837912);
            mMap.addMarker(new MarkerOptions().position(Laldighi).title("Laldighir Par"));
            LatLng Kotwali = new LatLng(22.333495, 91.836502);
            mMap.addMarker(new MarkerOptions().position(Kotwali).title("Kotwali"));
            LatLng newmarket = new LatLng(22.333892, 91.832565);
            mMap.addMarker(new MarkerOptions().position(newmarket).title("New Market"));
            LatLng Kadamtoli = new LatLng(22.336906, 91.822149);
            mMap.addMarker(new MarkerOptions().position(Kadamtoli).title("Kadamtoli"));
            LatLng Tigerpass = new LatLng(22.342076, 91.815782);
            mMap.addMarker(new MarkerOptions().position(Tigerpass).title("Tigerpass"));
            LatLng Dewanhat = new LatLng(22.338556, 91.813583);
            mMap.addMarker(new MarkerOptions().position(Dewanhat).title("Dewanhat"));
            LatLng Choumohoni = new LatLng(22.332594, 91.812554);
            mMap.addMarker(new MarkerOptions().position(Choumohoni).title("Choumohoni"));
            LatLng Agrabad = new LatLng(22.327704, 91.812264);
            mMap.addMarker(new MarkerOptions().position(Agrabad).title("Agrabad"));
            LatLng Badamtoli = new LatLng(22.326732, 91.812264);
            mMap.addMarker(new MarkerOptions().position(Badamtoli).title("Badamtoli"));
            LatLng Barik  = new LatLng(22.319393, 91.811998);
            mMap.addMarker(new MarkerOptions().position(Barik).title("Barik Building"));
            LatLng Sagorika = new LatLng(22.315921, 91.807452);
            mMap.addMarker(new MarkerOptions().position(Sagorika).title("Sagorika"));
            LatLng Fakir = new LatLng(22.314911, 91.805071);
            mMap.addMarker(new MarkerOptions().position(Fakir).title("Fakir Hat"));
            LatLng Customs = new LatLng(22.311996, 91.799397);
            mMap.addMarker(new MarkerOptions().position(Customs).title("Customs"));
            LatLng Saltgola= new LatLng(22.305306, 91.793214);
            mMap.addMarker(new MarkerOptions().position(Saltgola).title("Saltgola"));
            LatLng Crossing = new LatLng(22.302457, 91.791584);
            mMap.addMarker(new MarkerOptions().position(Crossing).title("Salt Gola Crossing"));
            LatLng Seamens = new LatLng(22.300859, 91.788751);
            mMap.addMarker(new MarkerOptions().position(Seamens).title("Seamens Hostel"));
            LatLng mm2 = new LatLng(22.300104, 91.786638);
            mMap.addMarker(new MarkerOptions().position(mm2).title("Mailer Matha 2"));
            LatLng mm1 = new LatLng(22.299193, 91.785479);
            mMap.addMarker(new MarkerOptions().position(mm1).title("Mailer Matha 1"));
            LatLng CEPZ = new LatLng(22.293334, 91.782173);
            mMap.addMarker(new MarkerOptions().position(CEPZ).title("CEPZ"));
            LatLng Bandartila = new LatLng(22.286629, 91.784194);
            mMap.addMarker(new MarkerOptions().position(Bandartila).title("Bandartila"));
            LatLng Hospital = new LatLng(22.282962, 91.784614);
            mMap.addMarker(new MarkerOptions().position(Hospital).title("Hospital Gate"));
            LatLng Cement = new LatLng(22.278756, 91.785422);
            mMap.addMarker(new MarkerOptions().position(Cement).title("Cement Crossing"));
            LatLng Steel = new LatLng(22.270674, 91.787669);
            mMap.addMarker(new MarkerOptions().position(Steel).title("Steel Mill Bazar"));
            LatLng Kathgar = new LatLng(22.259710, 91.791843);
            mMap.addMarker(new MarkerOptions().position(Kathgar).title("Kathgar"));
            LatLng Patenga = new LatLng(22.236512, 91.793524);
            mMap.addMarker(new MarkerOptions().position(Patenga).title("Patenga"));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newmarket, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
               return;
            }
            mMap.addPolyline(new PolylineOptions().add(Laldighi,new LatLng(22.338487, 91.837515),new LatLng(22.336998, 91.837289),new LatLng(22.335212, 91.836828),
                    new LatLng(22.333773, 91.836581),new LatLng(22.333376, 91.836098),new LatLng(22.333466, 91.834489),new LatLng(22.333922, 91.832601),
                    new LatLng(22.334374, 91.830805),new LatLng(22.335287, 91.829914),new LatLng(22.335486, 91.829292),new LatLng(22.335605, 91.828187),
                    new LatLng(22.335506, 91.827339),new LatLng(22.335555, 91.826867),new LatLng(22.336111, 91.824722),new LatLng(22.336607, 91.823810),
                    new LatLng(22.336905, 91.822222),new LatLng(22.337282, 91.820344),new LatLng(22.338404, 91.820333),new LatLng(22.339594, 91.819228),
                    new LatLng(22.340924, 91.817544),new LatLng(22.341718, 91.816332),new LatLng(22.342046, 91.815827),new LatLng(22.338592, 91.813564),
                    new LatLng(22.337639, 91.812673),new LatLng(22.336101, 91.812416),new LatLng(22.334226, 91.812587),new LatLng(22.332717, 91.812641),
                    new LatLng(22.331675, 91.812340),new LatLng(22.330097, 91.812383),new LatLng(22.328827, 91.812340),new LatLng(22.327428, 91.812308),
                    new LatLng(22.323716, 91.812255),new LatLng(22.321314, 91.812104),new LatLng(22.319428, 91.812062),new LatLng(22.318386, 91.810688),
                    new LatLng(22.317443, 91.810066),new LatLng(22.316600, 91.808854),new LatLng(22.315895, 91.807352),new LatLng(22.314982, 91.805313),
                    new LatLng(22.314515, 91.803800),new LatLng(22.314118, 91.802899),new LatLng(22.313364, 91.801708),new LatLng(22.312004, 91.799391),
                    new LatLng(22.308798, 91.796269),new LatLng(22.306545, 91.794177),new LatLng(22.304689, 91.792986),new LatLng(22.303259, 91.792267),
                    new LatLng(22.302644, 91.791805),new LatLng(22.301175, 91.789649),new LatLng(22.300877, 91.788705),new LatLng(22.300659, 91.787771),
                    new LatLng(22.299735, 91.786033),new LatLng(22.299080, 91.785368),new LatLng(22.297571, 91.784327),new LatLng(22.293363, 91.782150),
                    new LatLng(22.291000, 91.782600),new LatLng(22.290414, 91.782804),new LatLng(22.289471, 91.783201),new LatLng(22.286692, 91.784177),
                    new LatLng(22.285540, 91.784456),new LatLng(22.283664, 91.784628),new LatLng(22.282194, 91.784606),new LatLng(22.278739, 91.785433),
                    new LatLng(22.277806, 91.785840),new LatLng(22.273210, 91.786902),new LatLng(22.270777, 91.787621),new LatLng(22.266895, 91.788844),
                    new LatLng(22.263728, 91.790207),new LatLng(22.262050, 91.790818),new LatLng(22.260600, 91.791269),new LatLng(22.259974, 91.791730),
                    new LatLng(22.258078, 91.792331),new LatLng(22.257025, 91.792514),new LatLng(22.254781, 91.790765),new LatLng(22.251961, 91.790883),
                    new LatLng(22.249558, 91.791162),new LatLng(22.244037, 91.791988),new LatLng(22.240551, 91.792535),new LatLng(22.238228, 91.792793),
                    new LatLng(22.237165, 91.793125),Patenga).width(15).color(Color.RED));

        }
        if(busname.equals("07 No bus")) {
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
            LatLng newmarket = new LatLng(22.333961, 91.832446);
            mMap.addMarker(new MarkerOptions().position(newmarket).title("New Market"));
            LatLng Kadamtoli = new LatLng(22.336916, 91.822198);
            mMap.addMarker(new MarkerOptions().position(Kadamtoli).title("Kadamtoli"));
            LatLng Tigerpass = new LatLng(22.341999, 91.815827);
            mMap.addMarker(new MarkerOptions().position(Tigerpass).title("Tigerpass"));
            LatLng Dewanhat = new LatLng(22.338558, 91.813536);
            mMap.addMarker(new MarkerOptions().position(Dewanhat).title("Dewanhat"));
            LatLng Choumohoni = new LatLng(22.332721, 91.812659);
            mMap.addMarker(new MarkerOptions().position(Choumohoni).title("Choumohoni"));
            LatLng Agrabad = new LatLng(22.327620, 91.812316);
            mMap.addMarker(new MarkerOptions().position(Agrabad).title("Agrabad"));
            LatLng Bepari = new LatLng(22.328326, 91.803966);
            mMap.addMarker(new MarkerOptions().position(Bepari).title("Bepari Para"));
            LatLng Shantibag = new LatLng(22.329860, 91.797306);
            mMap.addMarker(new MarkerOptions().position(Shantibag).title("Shantibag"));
            LatLng Access = new LatLng(22.329240, 91.789222);
            mMap.addMarker(new MarkerOptions().position(Access).title("Agrabad Access Road"));
            LatLng Noya = new LatLng(22.344041, 91.787706);
            mMap.addMarker(new MarkerOptions().position(Noya).title("Noya Bazar"));
            LatLng Sharaipara = new LatLng(22.349695, 91.786058);
            mMap.addMarker(new MarkerOptions().position(Sharaipara).title("Sharaipara"));
            LatLng Alongkar = new LatLng(22.358508, 91.782171);
            mMap.addMarker(new MarkerOptions().position(Alongkar).title("Alongkar Mor"));
            LatLng AKKhan = new LatLng(22.362810, 91.781908);
            mMap.addMarker(new MarkerOptions().position(AKKhan).title("AK Khan"));
            LatLng Kaibalyadham = new LatLng(22.363863, 91.781529);
            mMap.addMarker(new MarkerOptions().position(Kaibalyadham).title("Kaibalyadham"));
            LatLng Colonelhat = new LatLng(22.369038, 91.777838);
            mMap.addMarker(new MarkerOptions().position(Colonelhat).title("Colonel Hat"));
            LatLng CDA = new LatLng(22.371769, 91.775216);
            mMap.addMarker(new MarkerOptions().position(CDA).title("CDA No 1"));
            LatLng CityGate = new LatLng(22.374216, 91.772926);
            mMap.addMarker(new MarkerOptions().position(CityGate).title("City Gate"));
            LatLng KalirHat = new LatLng(22.375754, 91.770956);
            mMap.addMarker(new MarkerOptions().position(KalirHat).title("Kalir Hat"));
            LatLng PakkarMatha = new LatLng(22.380458, 91.765962);
            mMap.addMarker(new MarkerOptions().position(PakkarMatha).title("Pakkar Matha"));
            LatLng Fakirhat = new LatLng(22.386288, 91.761742);
            mMap.addMarker(new MarkerOptions().position(Fakirhat).title("Fakirhat"));
            LatLng Faujdarhat = new LatLng(22.402630, 91.756547);
            mMap.addMarker(new MarkerOptions().position(Faujdarhat).title("Faujdarhat"));
            LatLng Bhatiari = new LatLng(22.424544, 91.745863);
            mMap.addMarker(new MarkerOptions().position(Bhatiari).title("Bhatiari"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newmarket, 18));

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
             return;
            }
            mMap.addPolyline(new PolylineOptions().add(newmarket,new LatLng(22.334318, 91.830858),new LatLng(22.335261, 91.829903),new LatLng(22.335449, 91.829474),
                    new LatLng(22.335588, 91.828068),new LatLng(22.335529, 91.827317),new LatLng(22.336015, 91.825032),new LatLng(22.336581, 91.823852),
                    new LatLng(22.336938, 91.822157),new LatLng(22.337255, 91.820408),new LatLng(22.338436, 91.820311),new LatLng(22.339637, 91.819163),
                    new LatLng(22.341076, 91.817286),new LatLng(22.341999, 91.815848),new LatLng(22.338605, 91.813531),new LatLng(22.337732, 91.812726),
                    new LatLng(22.336045, 91.812447),new LatLng(22.332710, 91.812651),new LatLng(22.331678, 91.812340),new LatLng(22.329584, 91.812393),
                    new LatLng(22.327480, 91.812286),new LatLng(22.327530, 91.808746),new LatLng(22.327579, 91.807962),new LatLng(22.327708, 91.807158),
                    new LatLng(22.327857, 91.805688),new LatLng(22.328314, 91.803982),new LatLng(22.329306, 91.801075),new LatLng(22.329842, 91.799068),
                    new LatLng(22.329912, 91.797802),new LatLng(22.329693, 91.795077),new LatLng(22.329326, 91.791215),new LatLng(22.329276, 91.789166),
                    new LatLng(22.334153, 91.788919),new LatLng(22.338619, 91.788501),new LatLng(22.341219, 91.787879),new LatLng(22.344027, 91.787675),
                    new LatLng(22.345823, 91.787589),new LatLng(22.347520, 91.787170),new LatLng(22.349703, 91.786044),new LatLng(22.353365, 91.784864),
                    new LatLng(22.355290, 91.784113),new LatLng(22.357899, 91.782364),new LatLng(22.360231, 91.781838),new LatLng(22.362860, 91.781881),
                    new LatLng(22.364507, 91.781291),new LatLng(22.369012, 91.777847),new LatLng(22.369875, 91.776731),new LatLng(22.371691, 91.775261),
                    new LatLng(22.372345, 91.774779),new LatLng(22.373774, 91.773416),new LatLng(22.375113, 91.771785),new LatLng(22.375857, 91.770852),
                    new LatLng(22.377772, 91.769371),new LatLng(22.378466, 91.768524),new LatLng(22.379349, 91.767429),new LatLng(22.380054, 91.766389),
                    new LatLng(22.380639, 91.765766),new LatLng(22.382653, 91.764393),new LatLng(22.386175, 91.761775),new LatLng(22.391107, 91.759565),
                    new LatLng(22.393428, 91.758878),new LatLng(22.396414, 91.758245),new LatLng(22.402604, 91.756611),new LatLng(22.408808, 91.755037),
                    new LatLng(22.411394, 91.754457),new LatLng(22.413169, 91.753942),new LatLng(22.414518, 91.753245),new LatLng(22.415470, 91.752623),
                    new LatLng(22.418237, 91.750584),new LatLng(22.420439, 91.749372),new LatLng(22.422214, 91.748256),new LatLng(22.423087, 91.747409),
                    Bhatiari).width(15).color(Color.RED));

        }
        if(busname.equals("08 No bus")) {
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
            LatLng newmarket = new LatLng(22.333909, 91.832431);
            mMap.addMarker(new MarkerOptions().position(newmarket).title("New Market"));
            LatLng BRTC = new LatLng(22.336305, 91.824385);
            mMap.addMarker(new MarkerOptions().position(BRTC).title("BRTC"));
            LatLng Kadamtoli = new LatLng(22.336910, 91.822314);
            mMap.addMarker(new MarkerOptions().position(Kadamtoli).title("Kadamtoli"));
            LatLng Tigerpass  = new LatLng(22.342033, 91.815835);
            mMap.addMarker(new MarkerOptions().position(Tigerpass).title("Tigerpass"));
            LatLng Ispahani = new LatLng(22.347282, 91.819171);
            mMap.addMarker(new MarkerOptions().position(Ispahani).title("Ispahani Circle"));
            LatLng LalKhan = new LatLng(22.347510, 91.819407);
            mMap.addMarker(new MarkerOptions().position(LalKhan).title("Lal Khan Bazar"));
            LatLng Wasa = new LatLng(22.351842, 91.821995);
            mMap.addMarker(new MarkerOptions().position(Wasa).title("Wasa"));
            LatLng Garibulla = new LatLng(22.356579, 91.821618);
            mMap.addMarker(new MarkerOptions().position(Garibulla).title("Garibulla Shah A/C"));
            LatLng GEC = new LatLng(22.359040, 91.821490);
            mMap.addMarker(new MarkerOptions().position(GEC).title("GEC"));
            LatLng twoNo = new LatLng(22.366486, 91.822998);
            mMap.addMarker(new MarkerOptions().position(twoNo).title("2 No. Gate"));
            LatLng Bayazid = new LatLng(22.370592, 91.816665);
            mMap.addMarker(new MarkerOptions().position(Bayazid).title("Bayazid Bostami Road"));
            LatLng Oxyzen = new LatLng(22.393510, 91.821450);
            mMap.addMarker(new MarkerOptions().position(Oxyzen).title("Oxyzen"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newmarket, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
           return;
            }
            mMap.addPolyline(new PolylineOptions().add(newmarket,new LatLng(22.334346, 91.830822),new LatLng(22.335189, 91.829964),new LatLng(22.335457, 91.829513),
                    new LatLng(22.335586, 91.828183),new LatLng(22.335487, 91.827346),new LatLng(22.336043, 91.825028),new LatLng(22.336569, 91.823891),
                    new LatLng(22.336916, 91.822217),new LatLng(22.337253, 91.820415),new LatLng(22.338395, 91.820329),new LatLng(22.339645, 91.819160),
                    new LatLng(22.340885, 91.817582),new LatLng(22.341679, 91.816424),new LatLng(22.342007, 91.815834),new LatLng(22.344150, 91.817293),
                    new LatLng(22.345391, 91.817840),new LatLng(22.346651, 91.818602),new LatLng(22.347435, 91.819299),new LatLng(22.348467, 91.820275),
                    new LatLng(22.349320, 91.821166),new LatLng(22.350213, 91.821692),new LatLng(22.351146, 91.822024),new LatLng(22.354827, 91.821949),
                    new LatLng(22.358181, 91.821370),new LatLng(22.359024, 91.821488),new LatLng(22.359997, 91.821745),new LatLng(22.363012, 91.821016),
                    new LatLng(22.364351, 91.821199),new LatLng(22.365344, 91.821757),new LatLng(22.366455, 91.822990),new LatLng(22.367447, 91.821038),
                    new LatLng(22.368082, 91.819707),new LatLng(22.369332, 91.818087),new LatLng(22.370344, 91.816789),new LatLng(22.374458, 91.814245),
                    new LatLng(22.378634, 91.811724),new LatLng(22.381710, 91.811048),new LatLng(22.386912, 91.810734),new LatLng(22.390239, 91.810636),
                    new LatLng(22.391251, 91.811183),new LatLng(22.392719, 91.812267),new LatLng(22.392845, 91.815439),new LatLng(22.393083, 91.819129),
                    Oxyzen).width(15).color(Color.RED));

        }
        if(busname.equals("09 No bus")) {
            Toast.makeText(getApplicationContext(), busname +" is not available",
                    Toast.LENGTH_LONG).show();
        }
        if(busname.equals("10 No bus")) {
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
            LatLng Patenga = new LatLng(22.236500, 91.793452);
            mMap.addMarker(new MarkerOptions().position(Patenga).title("Patenga"));
            LatLng Kathgar = new LatLng(22.260059, 91.791689);
            mMap.addMarker(new MarkerOptions().position(Kathgar).title("Kathgar"));
            LatLng Steel = new LatLng(22.270697, 91.787646);
            mMap.addMarker(new MarkerOptions().position(Steel).title("Steel Mill Bazar"));
            LatLng Cement = new LatLng(22.278759, 91.785415);
            mMap.addMarker(new MarkerOptions().position(Cement).title("Cement Crossing"));
            LatLng Hospital = new LatLng(22.282916, 91.784537);
            mMap.addMarker(new MarkerOptions().position(Hospital).title("Hospital Gate"));
            LatLng Bandartila = new LatLng(22.286751, 91.784141);
            mMap.addMarker(new MarkerOptions().position(Bandartila).title("Bandartila"));
            LatLng CEPZ = new LatLng(22.293388, 91.782126);
            mMap.addMarker(new MarkerOptions().position(CEPZ).title("CEPZ"));
            LatLng mm1 = new LatLng(22.299189, 91.785365);
            mMap.addMarker(new MarkerOptions().position(mm1).title("Mailer Matha 1"));
            LatLng mm2 = new LatLng(22.300122, 91.786610);
            mMap.addMarker(new MarkerOptions().position(mm2).title("Mailer Matha 2"));
            LatLng Seamens = new LatLng(22.300956, 91.788692);
            mMap.addMarker(new MarkerOptions().position(Seamens).title("Seamens Hostel"));
            LatLng Crossing = new LatLng(22.302445, 91.791460);
            mMap.addMarker(new MarkerOptions().position(Crossing).title("Salt Gola Crossing"));
            LatLng Saltgola= new LatLng(22.305493, 91.793198);
            mMap.addMarker(new MarkerOptions().position(Saltgola).title("Saltgola"));
            LatLng Customs = new LatLng(22.312062, 91.799319);
            mMap.addMarker(new MarkerOptions().position(Customs).title("Customs"));
            LatLng Fakir = new LatLng(22.314956, 91.805185);
            mMap.addMarker(new MarkerOptions().position(Fakir).title("Fakir Hat"));
            LatLng Sagorika = new LatLng(22.315988, 91.807482);
            mMap.addMarker(new MarkerOptions().position(Sagorika).title("Sagorika"));
            LatLng Barik  = new LatLng(22.319462, 91.812095);
            mMap.addMarker(new MarkerOptions().position(Barik).title("Barik Building"));
            LatLng Badamtoli = new LatLng(22.326843, 91.812292);
            mMap.addMarker(new MarkerOptions().position(Badamtoli).title("Badamtoli"));
            LatLng Agrabad = new LatLng(22.327755, 91.812304);
            mMap.addMarker(new MarkerOptions().position(Agrabad).title("Agrabad"));
            LatLng Choumohoni = new LatLng(22.332711, 91.812575);
            mMap.addMarker(new MarkerOptions().position(Choumohoni).title("Choumohoni"));
            LatLng Dewanhat = new LatLng(22.338567, 91.813495);
            mMap.addMarker(new MarkerOptions().position(Dewanhat).title("Dewanhat"));
            LatLng Tigerpass = new LatLng(22.342125, 91.815841);
            mMap.addMarker(new MarkerOptions().position(Tigerpass).title("Tigerpass"));
            LatLng Ispahani = new LatLng(22.347230, 91.819003);
            mMap.addMarker(new MarkerOptions().position(Ispahani).title("Ispahani"));
            LatLng LalKhan = new LatLng(22.347568, 91.819368);
            mMap.addMarker(new MarkerOptions().position(LalKhan).title("Lal Khan Bazar"));
            LatLng Wasa = new LatLng(22.351854, 91.821964);
            mMap.addMarker(new MarkerOptions().position(Wasa).title("Wasa Bus Stop"));
            LatLng Garibulla = new LatLng(22.356363, 91.821643);
            mMap.addMarker(new MarkerOptions().position(Garibulla).title("Garibulla Shah A/C"));
            LatLng GEC = new LatLng(22.359098, 91.821448);
            mMap.addMarker(new MarkerOptions().position(GEC).title("GEC"));
            LatLng twoNo = new LatLng(22.366499, 91.822956);
            mMap.addMarker(new MarkerOptions().position(twoNo).title("2 NO. Gate"));
            LatLng Muradpur = new LatLng(22.369094, 91.832978);
            mMap.addMarker(new MarkerOptions().position(Muradpur).title("Muradpur"));
            LatLng Bahaddarhat = new LatLng(22.368447, 91.843791);
            mMap.addMarker(new MarkerOptions().position(Bahaddarhat).title("Bahaddarhat"));
            LatLng Hazera  = new LatLng(22.378329, 91.853641);
            mMap.addMarker(new MarkerOptions().position(Hazera).title("Hazera - Taju Degree College"));
            LatLng CNB = new LatLng(22.387445, 91.860824);
            mMap.addMarker(new MarkerOptions().position(CNB).title("CNB"));
            LatLng Kaptai = new LatLng(22.394399, 91.868584);
            mMap.addMarker(new MarkerOptions().position(Kaptai).title("Kaptai Rastar Matha"));
            LatLng Moulovi = new LatLng(22.397080, 91.878602);
            mMap.addMarker(new MarkerOptions().position(Moulovi).title("Moulovi Bazar"));
            LatLng Kalurghat = new LatLng(22.397232, 91.885891);
            mMap.addMarker(new MarkerOptions().position(Kalurghat).title("Kalurghat"));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Patenga, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
              return;
            }

            mMap.addPolyline(new PolylineOptions().add(Patenga,new LatLng(22.237707, 91.792918),new LatLng(22.240507, 91.792521),new LatLng(22.244499, 91.791909),
                    new LatLng(22.248025, 91.791394),new LatLng(22.250795, 91.790944),new LatLng(22.254727, 91.790751),new LatLng(22.255988, 91.791663),
                    new LatLng(22.257150, 91.792510),new LatLng(22.258262, 91.792285),new LatLng(22.259980, 91.791705),new LatLng(22.260586, 91.791266),
                    new LatLng(22.263376, 91.790364),new LatLng(22.265578, 91.789406),new LatLng(22.268293, 91.788399),new LatLng(22.270686, 91.787638),
                    new LatLng(22.274789, 91.786541),new LatLng(22.277856, 91.785801),new LatLng(22.278750, 91.785415),new LatLng(22.282185, 91.784578),
                    new LatLng(22.283178, 91.784600),new LatLng(22.284965, 91.784503),new LatLng(22.285918, 91.784374),new LatLng(22.286732, 91.784127),
                    new LatLng(22.289564, 91.783106),new LatLng(22.290527, 91.782752),new LatLng(22.293326, 91.782130),new LatLng(22.297214, 91.784145),
                    new LatLng(22.299199, 91.785454),new LatLng(22.300182, 91.786763),new LatLng(22.300658, 91.787761),new LatLng(22.300916, 91.788791),
                    new LatLng(22.301045, 91.789402),new LatLng(22.302504, 91.791602),new LatLng(22.302762, 91.791956),new LatLng(22.304271, 91.792599),
                    new LatLng(22.306706, 91.794144),new LatLng(22.308240, 91.795775),new LatLng(22.311999, 91.799369),new LatLng(22.313433, 91.801863),
                    new LatLng(22.314267, 91.803108),new LatLng(22.314545, 91.803869),new LatLng(22.314942, 91.805232),new LatLng(22.315935, 91.807539),
                    new LatLng(22.316739, 91.809159),new LatLng(22.317443, 91.810060),new LatLng(22.318386, 91.810672),new LatLng(22.319508, 91.812120),
                    new LatLng(22.323635, 91.812233),new LatLng(22.327605, 91.812255),new LatLng(22.330136, 91.812366),new LatLng(22.331863, 91.812356),
                    new LatLng(22.332806, 91.812656),new LatLng(22.336061, 91.812409),new LatLng(22.337738, 91.812742),new LatLng(22.338612, 91.813568),
                    new LatLng(22.342025, 91.815789),new LatLng(22.344069, 91.817237),new LatLng(22.345399, 91.817817),new LatLng(22.346679, 91.818611),
                    new LatLng(22.347533, 91.819362),new LatLng(22.349051, 91.821014),new LatLng(22.349765, 91.821422),new LatLng(22.351184, 91.822012),
                    new LatLng(22.354816, 91.821937),new LatLng(22.358388, 91.821325),new LatLng(22.359797, 91.821754),new LatLng(22.362854, 91.821037),
                    new LatLng(22.364075, 91.821144),new LatLng(22.365464, 91.821863),new LatLng(22.366506, 91.822946),new LatLng(22.367081, 91.823998),
                    new LatLng(22.367389, 91.824770),new LatLng(22.368629, 91.829663),new LatLng(22.369016, 91.831175),new LatLng(22.369075, 91.833107),
                    new LatLng(22.368758, 91.836379),new LatLng(22.368212, 91.838847),new LatLng(22.368053, 91.839887),new LatLng(22.367954, 91.841743),
                    new LatLng(22.368113, 91.842945),new LatLng(22.368549, 91.844071),new LatLng(22.372044, 91.847390),new LatLng(22.376132, 91.851520),
                    new LatLng(22.379148, 91.854374),new LatLng(22.380844, 91.854814),new LatLng(22.381678, 91.855597),new LatLng(22.382531, 91.856284),
                    new LatLng(22.383047, 91.856928),new LatLng(22.385686, 91.858955),new LatLng(22.387432, 91.860833),new LatLng(22.389416, 91.862861),
                    new LatLng(22.391241, 91.863816),new LatLng(22.393602, 91.865237),new LatLng(22.394385, 91.868440),new LatLng(22.394896, 91.870720),
                    new LatLng(22.395452, 91.873348),new LatLng(22.396196, 91.875762),new LatLng(22.397039, 91.878562),new LatLng(22.397565, 91.880365),
                    new LatLng(22.398031, 91.882071),new LatLng(22.398011, 91.882757),new LatLng(22.397823, 91.884056),new LatLng(22.397733, 91.885150),
                    new LatLng(22.397574, 91.885397),new LatLng(22.397356, 91.885847),Kalurghat).width(15).color(Color.RED));


        }
        if(busname.equals("11 No bus")) {
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
            LatLng Patenga = new LatLng(22.236500, 91.793452);
            mMap.addMarker(new MarkerOptions().position(Patenga).title("Patenga"));
            LatLng Kathgar = new LatLng(22.260059, 91.791689);
            mMap.addMarker(new MarkerOptions().position(Kathgar).title("Kathgar"));
            LatLng Steel = new LatLng(22.270697, 91.787646);
            mMap.addMarker(new MarkerOptions().position(Steel).title("Steel Mill Bazar"));
            LatLng Cement = new LatLng(22.278759, 91.785415);
            mMap.addMarker(new MarkerOptions().position(Cement).title("Cement Crossing"));
            LatLng Hospital = new LatLng(22.282916, 91.784537);
            mMap.addMarker(new MarkerOptions().position(Hospital).title("Hospital Gate"));
            LatLng Bandartila = new LatLng(22.286751, 91.784141);
            mMap.addMarker(new MarkerOptions().position(Bandartila).title("Bandartila"));
            LatLng CEPZ = new LatLng(22.293388, 91.782126);
            mMap.addMarker(new MarkerOptions().position(CEPZ).title("CEPZ"));
            LatLng mm1 = new LatLng(22.299189, 91.785365);
            mMap.addMarker(new MarkerOptions().position(mm1).title("Mailer Matha 1"));
            LatLng mm2 = new LatLng(22.300122, 91.786610);
            mMap.addMarker(new MarkerOptions().position(mm2).title("Mailer Matha 2"));
            LatLng Seamens = new LatLng(22.300956, 91.788692);
            mMap.addMarker(new MarkerOptions().position(Seamens).title("Seamens Hostel"));
            LatLng Crossing = new LatLng(22.302445, 91.791460);
            mMap.addMarker(new MarkerOptions().position(Crossing).title("Salt Gola Crossing"));
            LatLng Saltgola= new LatLng(22.305493, 91.793198);
            mMap.addMarker(new MarkerOptions().position(Saltgola).title("Saltgola"));
            LatLng Customs = new LatLng(22.312062, 91.799319);
            mMap.addMarker(new MarkerOptions().position(Customs).title("Customs"));
            LatLng Fakir = new LatLng(22.314956, 91.805185);
            mMap.addMarker(new MarkerOptions().position(Fakir).title("Fakir Hat"));
            LatLng Sagorika = new LatLng(22.315988, 91.807482);
            mMap.addMarker(new MarkerOptions().position(Sagorika).title("Sagorika"));
            LatLng Barik  = new LatLng(22.319462, 91.812095);
            mMap.addMarker(new MarkerOptions().position(Barik).title("Barik Building"));
            LatLng Badamtoli = new LatLng(22.326843, 91.812292);
            mMap.addMarker(new MarkerOptions().position(Badamtoli).title("Badamtoli"));
            LatLng Agrabad = new LatLng(22.327755, 91.812304);
            mMap.addMarker(new MarkerOptions().position(Agrabad).title("Agrabad"));
            LatLng Bepari = new LatLng(22.328326, 91.803966);
            mMap.addMarker(new MarkerOptions().position(Bepari).title("Bepari Para"));
            LatLng Shantibag = new LatLng(22.329860, 91.797306);
            mMap.addMarker(new MarkerOptions().position(Shantibag).title("Shantibag"));
            LatLng Access = new LatLng(22.329240, 91.789222);
            mMap.addMarker(new MarkerOptions().position(Access).title("Agrabad Access Road"));
            LatLng Noya = new LatLng(22.344041, 91.787706);
            mMap.addMarker(new MarkerOptions().position(Noya).title("Noya Bazar"));
            LatLng Sharaipara = new LatLng(22.349695, 91.786058);
            mMap.addMarker(new MarkerOptions().position(Sharaipara).title("Sharaipara"));
            LatLng Alongkar = new LatLng(22.358508, 91.782171);
            mMap.addMarker(new MarkerOptions().position(Alongkar).title("Alongkar Mor"));
            LatLng AKKhan = new LatLng(22.362810, 91.781908);
            mMap.addMarker(new MarkerOptions().position(AKKhan).title("AK Khan"));
            LatLng Kaibalyadham = new LatLng(22.363863, 91.781529);
            mMap.addMarker(new MarkerOptions().position(Kaibalyadham).title("Kaibalyadham"));
            LatLng Colonelhat = new LatLng(22.369038, 91.777838);
            mMap.addMarker(new MarkerOptions().position(Colonelhat).title("Colonel Hat"));
            LatLng CDA = new LatLng(22.371769, 91.775216);
            mMap.addMarker(new MarkerOptions().position(CDA).title("CDA No 1"));
            LatLng CityGate = new LatLng(22.374216, 91.772926);
            mMap.addMarker(new MarkerOptions().position(CityGate).title("City Gate"));
            LatLng KalirHat = new LatLng(22.375754, 91.770956);
            mMap.addMarker(new MarkerOptions().position(KalirHat).title("Kalir Hat"));
            LatLng PakkarMatha = new LatLng(22.380458, 91.765962);
            mMap.addMarker(new MarkerOptions().position(PakkarMatha).title("Pakkar Matha"));
            LatLng Fakirhat = new LatLng(22.386288, 91.761742);
            mMap.addMarker(new MarkerOptions().position(Fakirhat).title("Fakirhat"));
            LatLng Faujdarhat = new LatLng(22.402630, 91.756547);
            mMap.addMarker(new MarkerOptions().position(Faujdarhat).title("Faujdarhat"));
            LatLng Bhatiari = new LatLng(22.424544, 91.745863);
            mMap.addMarker(new MarkerOptions().position(Bhatiari).title("Bhatiari"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Patenga, 18));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
               return;
            }
            mMap.addPolyline(new PolylineOptions().add(Patenga,new LatLng(22.237707, 91.792918),new LatLng(22.240507, 91.792521),new LatLng(22.244499, 91.791909),
                    new LatLng(22.248025, 91.791394),new LatLng(22.250795, 91.790944),new LatLng(22.254727, 91.790751),new LatLng(22.255988, 91.791663),
                    new LatLng(22.257150, 91.792510),new LatLng(22.258262, 91.792285),new LatLng(22.259980, 91.791705),new LatLng(22.260586, 91.791266),
                    new LatLng(22.263376, 91.790364),new LatLng(22.265578, 91.789406),new LatLng(22.268293, 91.788399),new LatLng(22.270686, 91.787638),
                    new LatLng(22.274789, 91.786541),new LatLng(22.277856, 91.785801),new LatLng(22.278750, 91.785415),new LatLng(22.282185, 91.784578),
                    new LatLng(22.283178, 91.784600),new LatLng(22.284965, 91.784503),new LatLng(22.285918, 91.784374),new LatLng(22.286732, 91.784127),
                    new LatLng(22.289564, 91.783106),new LatLng(22.290527, 91.782752),new LatLng(22.293326, 91.782130),new LatLng(22.297214, 91.784145),
                    new LatLng(22.299199, 91.785454),new LatLng(22.300182, 91.786763),new LatLng(22.300658, 91.787761),new LatLng(22.300916, 91.788791),
                    new LatLng(22.301045, 91.789402),new LatLng(22.302504, 91.791602),new LatLng(22.302762, 91.791956),new LatLng(22.304271, 91.792599),
                    new LatLng(22.306706, 91.794144),new LatLng(22.308240, 91.795775),new LatLng(22.311999, 91.799369),new LatLng(22.313433, 91.801863),
                    new LatLng(22.314267, 91.803108),new LatLng(22.314545, 91.803869),new LatLng(22.314942, 91.805232),new LatLng(22.315935, 91.807539),
                    new LatLng(22.316739, 91.809159),new LatLng(22.317443, 91.810060),new LatLng(22.318386, 91.810672),new LatLng(22.319508, 91.812120),
                    new LatLng(22.323635, 91.812233),new LatLng(22.327534, 91.812285),new LatLng(22.327554, 91.808873),new LatLng(22.327563, 91.807907),
                    new LatLng(22.327712, 91.807210),new LatLng(22.327851, 91.805761),new LatLng(22.328010, 91.804850),new LatLng(22.328308, 91.803938),
                    new LatLng(22.329380, 91.800826),new LatLng(22.329806, 91.799281),new LatLng(22.329896, 91.798455),new LatLng(22.329787, 91.796266),
                    new LatLng(22.329469, 91.792887),new LatLng(22.329270, 91.790838),new LatLng(22.329241, 91.789196),new LatLng(22.334118, 91.788905),
                    new LatLng(22.337512, 91.788626),new LatLng(22.338812, 91.788443),new LatLng(22.340599, 91.787950),new LatLng(22.341690, 91.787821),
                    new LatLng(22.344092, 91.787671),new LatLng(22.345630, 91.787607),new LatLng(22.346404, 91.787489),new LatLng(22.347604, 91.787135),
                    new LatLng(22.349688, 91.786072),new LatLng(22.353395, 91.784825),new LatLng(22.355151, 91.784192),new LatLng(22.356878, 91.783087),
                    new LatLng(22.357900, 91.782325),new LatLng(22.358912, 91.782100),new LatLng(22.360003, 91.781864),new LatLng(22.362940, 91.781853),
                    new LatLng(22.364548, 91.781209),new LatLng(22.366584, 91.779650),new LatLng(22.369104, 91.777762),new LatLng(22.369794, 91.776818),
                    new LatLng(22.371694, 91.775251),new LatLng(22.372398, 91.774683),new LatLng(22.373767, 91.773460),new LatLng(22.375097, 91.771797),
                    new LatLng(22.375910, 91.770788),new LatLng(22.377180, 91.769790),new LatLng(22.378132, 91.768921),new LatLng(22.379283, 91.767484),
                    new LatLng(22.380236, 91.766164),new LatLng(22.381843, 91.764920),new LatLng(22.383400, 91.763793),new LatLng(22.386198, 91.761776),
                    new LatLng(22.389262, 91.760341),new LatLng(22.392694, 91.759029),new LatLng(22.396116, 91.758332),new LatLng(22.399242, 91.757485),
                    new LatLng(22.402735, 91.756521),new LatLng(22.408803, 91.755023),new LatLng(22.413197, 91.753933),new LatLng(22.414576, 91.753192),
                    new LatLng(22.415538, 91.752602),new LatLng(22.419015, 91.750145),new LatLng(22.420800, 91.749190),new LatLng(22.422556, 91.747945),
                    new LatLng(22.423458, 91.746980),Bhatiari).width(15).color(Color.RED));

        }
        if(busname.equals("12 No bus")) {
            Toast.makeText(getApplicationContext(), busname+" is not available",
                    Toast.LENGTH_LONG).show();
        }
        if(busname.equals("Current Location")) {
            mMap.setMyLocationEnabled(true);
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){

                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
            Toast.makeText(getApplicationContext(), busname,
                    Toast.LENGTH_LONG).show();
        }
    }
    public boolean checkUserLoactionPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},Request_User_Location_Code);
            }
            else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},Request_User_Location_Code);
            }
            return false;
        }
        else {
            return true;
        }
    }


    protected synchronized void buildGoogleApiClient(){
        googleApiClient=new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Request_User_Location_Code:
                if (grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) {
                    //Permission Granted
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
                    {
                        if (googleApiClient==null)
                            buildGoogleApiClient();
                        mMap.setMyLocationEnabled(true);
                    }
                } else
                    Toast.makeText(this, "Location Permission Denied", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        lastLocatin=location;
        if(currentUserLocatinMarker!=null){
            currentUserLocatinMarker.remove();
        }
        LatLng latLng=new LatLng(location.getLatitude(),location.getLongitude());
        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("User Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        currentUserLocatinMarker=mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
       // mMap.animateCamera(CameraUpdateFactory.zoomBy(14));

        if(googleApiClient!=null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient,this);

        }
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

        locationRequest=new LocationRequest();
        locationRequest.setInterval(1100);
        locationRequest.setFastestInterval(1100);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient,locationRequest,this);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(getApplicationContext(), "Connection suspended",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(getApplicationContext(), "Connection failed",
                Toast.LENGTH_LONG).show();
    }


}
