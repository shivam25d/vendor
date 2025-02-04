//package TestClasses;
//
//import com.vendor.Vendor_Insight.Controllers.VendorController;
//import com.vendor.Vendor_Insight.Entity.Vendor;
//import com.vendor.Vendor_Insight.Services.VendorService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@TestPropertySource(locations = "classpath:application-test.properties")
//public class VendorControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private VendorController vendorController;
//
//    @MockBean
//    private VendorService vendorService;
//
//    @BeforeEach
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(vendorController).build();
//    }
//
//    @Test
//    public void testGetVendorById_Success() throws Exception {
//        Vendor vendor = new Vendor();
//        vendor.setVendorId(1L);
//        vendor.setFirstName("John");
//
//        Mockito.doReturn(Optional.of(vendor)).when(vendorService).getVendorById(1L);
//
//        mockMvc.perform(get("/vendors/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.vendorId").value(1))
//                .andExpect(jsonPath("$.firstName").value("John"));
//    }
//
//    @Test
//    public void testGetVendorById_NotFound() throws Exception {
//        Mockito.doReturn(Optional.empty()).when(vendorService).getVendorById(1L);
//
//        mockMvc.perform(get("/vendors/1"))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.message").value("Vendor with ID 1 not found"));
//    }
//
//    @Test
//    public void testUpdateVendor_Success() throws Exception {
//        Vendor vendor = new Vendor();
//        vendor.setVendorId(1L);
//        vendor.setFirstName("John");
//
//        Vendor updatedVendor = new Vendor();
//        updatedVendor.setVendorId(1L);
//        updatedVendor.setFirstName("John Updated");
//
//        Mockito.doReturn(Optional.of(vendor)).when(vendorService).getVendorById(1L);
//        Mockito.doReturn(updatedVendor).when(vendorService).saveVendor(any(Vendor.class));
//
//        mockMvc.perform(put("/vendors/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"firstName\":\"John Updated\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName").value("John Updated"));
//    }
//
//    @Test
//    public void testCreateVendor_Success() throws Exception {
//        Vendor vendor = new Vendor();
//        vendor.setVendorId(1L);
//        vendor.setFirstName("John");
//
//        Mockito.doReturn(vendor).when(vendorService).saveVendor(any(Vendor.class));
//
//        mockMvc.perform(post("/vendors")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"firstName\":\"John\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.vendorId").value(1))
//                .andExpect(jsonPath("$.firstName").value("John"));
//    }
//
//    @Test
//    public void testDeleteVendor_Success() throws Exception {
//        Vendor vendor = new Vendor();
//        vendor.setVendorId(1L);
//
//        Mockito.doReturn(Optional.of(vendor)).when(vendorService).getVendorById(1L);
//        Mockito.doNothing().when(vendorService).deleteVendor(vendor.getVendorId());
//
//        mockMvc.perform(delete("/vendors/1"))
//                .andExpect(status().isNoContent());
//    }
//}


