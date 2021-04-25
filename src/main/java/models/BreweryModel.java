package models;

import com.fasterxml.jackson.annotation.*;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {
        "updated_at",
        "created_at"
})
public class BreweryModel {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("obdb_id")
        private String obdbId;
        @JsonProperty("name")
        private String name;
        @JsonProperty("brewery_type")
        private String breweryType;
        @JsonProperty("street")
        private String street;
        @JsonProperty("address_2")
        private String address2;
        @JsonProperty("address_3")
        private String address3;
        @JsonProperty("city")
        private String city;
        @JsonProperty("state")
        private String state;
        @JsonProperty("county_province")
        private String countyProvince;
        @JsonProperty("postal_code")
        private String postalCode;
        @JsonProperty("country")
        private String country;
        @JsonProperty("longitude")
        private String longitude;
        @JsonProperty("latitude")
        private String latitude;
        @JsonProperty("phone")
        private String phone;
        @JsonProperty("website_url")
        private String websiteUrl;
        @JsonProperty("updated_at")
        private String updatedAt;
        @JsonProperty("created_at")
        private String createdAt;

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("obdb_id")
        public String getObdbId() {
            return obdbId;
        }

        @JsonProperty("obdb_id")
        public void setObdbId(String obdbId) {
            this.obdbId = obdbId;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("brewery_type")
        public String getBreweryType() {
            return breweryType;
        }

        @JsonProperty("brewery_type")
        public void setBreweryType(String breweryType) {
            this.breweryType = breweryType;
        }

        @JsonProperty("street")
        public String getStreet() {
            return street;
        }

        @JsonProperty("street")
        public void setStreet(String street) {
            this.street = street;
        }

        @JsonProperty("address_2")
        public String getAddress2() {
            return address2;
        }

        @JsonProperty("address_2")
        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        @JsonProperty("address_3")
        public String getAddress3() {
            return address3;
        }

        @JsonProperty("address_3")
        public void setAddress3(String address3) {
            this.address3 = address3;
        }

        @JsonProperty("city")
        public String getCity() {
            return city;
        }

        @JsonProperty("city")
        public void setCity(String city) {
            this.city = city;
        }

        @JsonProperty("state")
        public String getState() {
            return state;
        }

        @JsonProperty("state")
        public void setState(String state) {
            this.state = state;
        }

        @JsonProperty("county_province")
        public String getCountyProvince() {
            return countyProvince;
        }

        @JsonProperty("county_province")
        public void setCountyProvince(String countyProvince) {
            this.countyProvince = countyProvince;
        }

        @JsonProperty("postal_code")
        public String getPostalCode() {
            return postalCode;
        }

        @JsonProperty("postal_code")
        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        @JsonProperty("country")
        public String getCountry() {
            return country;
        }

        @JsonProperty("country")
        public void setCountry(String country) {
            this.country = country;
        }

        @JsonProperty("longitude")
        public String getLongitude() {
            return longitude;
        }

        @JsonProperty("longitude")
        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        @JsonProperty("latitude")
        public String getLatitude() {
            return latitude;
        }

        @JsonProperty("latitude")
        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        @JsonProperty("phone")
        public String getPhone() {
            return phone;
        }

        @JsonProperty("phone")
        public void setPhone(String phone) {
            this.phone = phone;
        }

        @JsonProperty("website_url")
        public String getWebsiteUrl() {
            return websiteUrl;
        }

        @JsonProperty("website_url")
        public void setWebsiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
        }

        @JsonIgnore
        public String getUpdatedAt() {
            return updatedAt;
        }

        @JsonIgnore
        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        @JsonIgnore
        public String getCreatedAt() {
            return createdAt;
        }

        @JsonIgnore
        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreweryModel breweryModel = (BreweryModel) o;
        return Objects.equals(id, breweryModel.id) &&
                Objects.equals(obdbId, breweryModel.obdbId) &&
                Objects.equals(name, breweryModel.name) &&
                Objects.equals(breweryType, breweryModel.breweryType) &&
                Objects.equals(street, breweryModel.street) &&
                Objects.equals(address2, breweryModel.address2) &&
                Objects.equals(address3, breweryModel.address3) &&
                Objects.equals(city, breweryModel.city) &&
                Objects.equals(state, breweryModel.state) &&
                Objects.equals(countyProvince, breweryModel.countyProvince) &&
                Objects.equals(postalCode, breweryModel.postalCode) &&
                Objects.equals(country, breweryModel.country) &&
                Objects.equals(longitude, breweryModel.longitude) &&
                Objects.equals(latitude, breweryModel.latitude) &&
                Objects.equals(phone, breweryModel.phone) &&
                Objects.equals(websiteUrl, breweryModel.websiteUrl) &&
                Objects.equals(updatedAt, breweryModel.updatedAt) &&
                Objects.equals(createdAt, breweryModel.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, obdbId, name, breweryType, street, address2, address3, city, state, countyProvince, postalCode, country, longitude, latitude, phone, websiteUrl, updatedAt, createdAt);
    }

    @Override
    public String toString() {
        return "BreweryModel{" +
                "id=" + id +
                ", obdbId='" + obdbId + '\'' +
                ", name='" + name + '\'' +
                ", breweryType='" + breweryType + '\'' +
                ", street='" + street + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", countyProvince='" + countyProvince + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", phone='" + phone + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

}
