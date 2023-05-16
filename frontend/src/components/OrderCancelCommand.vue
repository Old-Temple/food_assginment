<template>

    <v-card outlined>
        <v-card-title>
            OrderCancel
        </v-card-title>

        <v-card-text>
            <Number label="MenuId" v-model="value.menuId" :editMode="editMode"/>
            <String label="MenuName" v-model="value.menuName" :editMode="editMode"/>
            <String label="Status" v-model="value.status" :editMode="editMode"/>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Number label="Price" v-model="value.price" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="orderCancel"
            >
                OrderCancel
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'OrderCancelCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.menuId = 0;
            this.value.menuName = '';
            this.value.status = '';
            this.value.userId = 0;
            this.value.price = 0;
        },
        watch: {
        },
        methods: {
            orderCancel() {
                this.$emit('orderCancel', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

