package ch5.corejava;

import java.util.ArrayList;
import java.util.List;

public class Demo12 {
    public static void main(String[] args) {

    }
}

/*

@Service
class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantMapper merchantMapper;
    @Autowired
    OssService ossService;

    @Override
    MerchantDTO getMerchantDTOById(String id) {
        Merchant merchant = merchantMapper.getById(id);
        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setId(merchant.getId());
        String displayName = merchant.getName();
        if (displayName.length() > 10) {
            displayName = displayName.substring(0, 10);
        }
        merchantDTO.setDisplayName(displayName);
        merchantDTO.setOnlineMerchant(merchant.getWebsite() != null);
        jumpToSea(merchantDTO);
        return merchantDTO;
    }

    @Override
    List<MerchantDTO> getMerchantDTOByCategory(String category) {
        List<Merchant> merchants = merchantMapper.getByCategory(category);
        List<MerchantDTO> merchantDTOs = new ArrayList<>();
        for (Merchant merchant : merchants) {
            MerchantDTO merchantDTO = new MerchantDTO();
            merchantDTO.setId(merchant.getId());
            String displayName = merchant.getName();
            if (displayName.length() > 10) {
                displayName = displayName.substring(0, 10);
            }
            merchantDTO.setDisplayName(displayName);
            merchantDTO.setOnlineMerchant(merchant.getWebsite() != null);
            jumpToSea(merchantDTO);
            merchantDTOs.add(merchantDTO);
        }
        return merchantDTOs;
    }

    private void jumpToSea(MerchantDTO merchantDTO) {
        String imageUrl = ossService.getImageUrl(merchantDTO.getId());
        merchantDTO.setImageUrl(imageUrl);
    }

}

class Merchant {
    private String id;
    private String name;
    private String address;
    private String website;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

class MerchantDTO {
    private String id;
    private String displayName;
    private String address;
    private String website;
    private Boolean isOnlineMerchant;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getOnlineMerchant() {
        return isOnlineMerchant;
    }

    public void setOnlineMerchant(Boolean onlineMerchant) {
        isOnlineMerchant = onlineMerchant;
    }
}*/
