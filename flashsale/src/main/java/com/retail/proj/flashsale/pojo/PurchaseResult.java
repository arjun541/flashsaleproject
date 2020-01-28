package com.retail.proj.flashsale.pojo;

public class PurchaseResult {

	 private Boolean status;

	    private String message;

	    private String purchaseOrderId;

		public Boolean getStatus() {
			return status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getPurchaseOrderId() {
			return purchaseOrderId;
		}

		public void PurchaseOrderId(String purchaseOrderId) {
			this.purchaseOrderId = purchaseOrderId;
		}
}
